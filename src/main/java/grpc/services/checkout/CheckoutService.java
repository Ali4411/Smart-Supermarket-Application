package grpc.services.checkout;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;

import data.CartProduct;
import data.CheckoutCart;
import data.CheckoutDataStore;
import data.Product;
import data.ProductDataStore;
import data.Voucher;
import grpc.services.checkout.CheckoutGrpc.CheckoutImplBase;
import grpc.services.inventorymanagement.InventoryManagerGrpc;
import grpc.services.inventorymanagement.InventoryManagerGrpc.InventoryManagerBlockingStub;
import grpc.services.inventorymanagement.ItemInfo;
import grpc.services.inventorymanagement.ItemRequest;
import grpc.services.inventorymanagement.Status;
import grpc.services.inventorymanagement.StockLevel;
import grpc.services.inventorymanagement.UpdateRequest;
import grpc.services.smartcart.CartStatus;
import grpc.services.smartcart.CartUpdateRequest;
import grpc.services.smartcart.SmartCartGrpc;
import grpc.services.smartcart.SmartCartGrpc.SmartCartBlockingStub;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class CheckoutService extends CheckoutImplBase {
    private static final Logger logger = Logger.getLogger(CheckoutService.class.getName());
    private static SmartCartBlockingStub cartBlockingStub;
    private static InventoryManagerBlockingStub inventoryblockingStub;

    public static void main(String[] args) {
		
		CheckoutService checkoutservice = new CheckoutService();
		
		int port = 50053;
	    
		try {
			Server server = ServerBuilder.forPort(port)
			    .addService(checkoutservice)
			    .build()
			    .start();

            CheckoutDataStore.initializeCheckout();

            ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50051).usePlaintext().build();
            inventoryblockingStub = InventoryManagerGrpc.newBlockingStub(channel);

            ManagedChannel cartChannel = ManagedChannelBuilder.forAddress("localhost", 50052).usePlaintext().build();
            cartBlockingStub = SmartCartGrpc.newBlockingStub(cartChannel);

			logger.info("Server started, listening on " + port);
			
			server.awaitTermination();
			 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

     @Override
    public StreamObserver<CheckoutRequest> transferForCheckout(StreamObserver<CheckoutContents> responseObserver) {

        return new StreamObserver<CheckoutRequest>() {
            float totalCost;
            CheckoutCart cart;

            @Override
            public void onNext(CheckoutRequest contents) {
                String cartId = contents.getCartId();
                String itemId = contents.getItem().getItemId();
                ItemInfo item = getProductFromInventory(itemId);
                CheckoutItem checkoutItem = CheckoutItem.newBuilder().setItemId(item.getItemId()).setName(item.getName()).setPrice(item.getPrice()).setQuantity(contents.getItem().getQuantity()).build();
                totalCost += item.getPrice() * contents.getItem().getQuantity();

                if(cart == null)
                {
                    cart = new CheckoutCart(cartId);
                }

                CartProduct cp = new CartProduct(item.getItemId(), item.getName(), item.getPrice(), contents.getItem().getQuantity());
                cart.addProduct(cp);

                responseObserver.onNext(CheckoutContents.newBuilder().setCartId(cartId).setTotal(totalCost).setItem(checkoutItem).build());
            }

            @Override
            public void onError(Throwable t) {
                System.out.println("An error occurred in transfer for checkout.");
            }

            @Override
            public void onCompleted() {        
                CheckoutDataStore.addCartToCheckout(cart);   
                responseObserver.onCompleted();
            }
      };
    }

    @Override
    public void applyDiscount(ApplyVoucher request, StreamObserver<VoucherResult> responseObserver) {
        String cartId=request.getCartId(); 
        String voucherCode=request.getVoucherCode(); 
		CheckoutCart cc = CheckoutDataStore.getCartInCheckout(cartId);
        VoucherResult reply;
        
        if(cc != null) {
            Voucher voucher = CheckoutDataStore.getVoucher(voucherCode);
            if(voucher != null) {
                cc.setAppliedVoucher(voucher);
                reply = VoucherResult.newBuilder().setSuccess(true).setMessage("Voucher applied succesfully.").setCartId(cartId).setDiscountAmount(voucher.getDiscountAmount()).build();
            }
            else {
                reply = VoucherResult.newBuilder().setSuccess(false).setMessage("Voucher code is not valid.").setCartId(cartId).build();
            }
        }
        else {
            reply = VoucherResult.newBuilder().setSuccess(false).setMessage("Cart is not in checkout.").setCartId(cartId).build();
        }

		 responseObserver.onNext(reply);
	     
	     responseObserver.onCompleted();
    }

    @Override
    public StreamObserver<CheckoutContents> processPayment(StreamObserver<Receipt> responseObserver) {
        return new StreamObserver<CheckoutContents>() {
            float totalCost;
            String cartId;
            List<CheckoutItem> checkoutItems = new ArrayList<>();

            @Override
            public void onNext(CheckoutContents contents) {
                cartId = contents.getCartId();
                ItemInfo item = getProductFromInventory(contents.getItem().getItemId());
                CheckoutItem checkoutItem = CheckoutItem.newBuilder().setItemId(item.getItemId()).setName(item.getName()).setPrice(item.getPrice()).setQuantity(contents.getItem().getQuantity()).build();
                checkoutItems.add(checkoutItem);
                totalCost += checkoutItem.getPrice() * checkoutItem.getQuantity();
            }

            @Override
            public void onError(Throwable t) {
                System.out.println("An error occurred in transfer for checkout.");
            }

            @Override
            public void onCompleted() {        
                CheckoutCart cc =CheckoutDataStore.getCartInCheckout(cartId);
                Receipt reply;
                if(cc != null) {
                    if(cc.getAppliedVoucher() != null){
                        totalCost = totalCost - cc.getAppliedVoucher().getDiscountAmount();
                        if(totalCost < 0){
                            totalCost = 0;
                        }
                    }

                    for (CheckoutItem checkoutItem : checkoutItems) {
                        removeItemFromCart(checkoutItem.getItemId(), checkoutItem.getQuantity());
                        reduceInventoryStock(checkoutItem.getItemId(), checkoutItem.getQuantity());
                    }

                    reply = Receipt.newBuilder().setSuccess(true).addAllPurchasedItems(checkoutItems).setTotal(totalCost).setTransactionId(UUID.randomUUID().toString()).build();
                }
                else{
                    reply = Receipt.newBuilder().setSuccess(false).setMessage("Cart is not in checkout.").build();
                }

                responseObserver.onNext(reply);
                responseObserver.onCompleted();
            }
      };
    }

    private ItemInfo getProductFromInventory(String productId)
	{
        //preparing message to send
        ItemRequest request = ItemRequest.newBuilder().setItemId(productId).build();

        //retreving reply from service
        return inventoryblockingStub.getItemInfo(request);
	}

    private Status reduceInventoryStock(String productId, int amountToReduce)
	{
        //preparing message to send
        UpdateRequest request = UpdateRequest.newBuilder().setItemId(productId).setQuantity(-amountToReduce).build();

        //retreving reply from service
        return inventoryblockingStub.updateStock(request);
	}

    private void removeItemFromCart(String productId, int amountToReduce)
	{
        for(int i =0; i < amountToReduce; i++) {
            CartUpdateRequest request5 = CartUpdateRequest.newBuilder().setCartId("cart_002").setItemId("item_003").build();

            //retreving reply from service
            cartBlockingStub.removeFromCart(request5);
        }
        
	}

    
}
