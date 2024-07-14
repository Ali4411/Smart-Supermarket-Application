package grpc.services.smartcart;

import java.io.IOException;
import java.util.logging.Logger;

import data.Cart;
import data.CartDataStore;
import data.CartProduct;
import grpc.services.inventorymanagement.InventoryManagerGrpc;
import grpc.services.inventorymanagement.InventoryManagerGrpc.InventoryManagerBlockingStub;
import grpc.services.inventorymanagement.ItemInfo;
import grpc.services.inventorymanagement.ItemRequest;
import grpc.services.smartcart.SmartCartGrpc.SmartCartImplBase;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class SmartCartService extends SmartCartImplBase {
    private static final Logger logger = Logger.getLogger(SmartCartService.class.getName());

    public static void main(String[] args) {
		
		SmartCartService smartcartservice = new SmartCartService();
		
		int port = 50052;
	    
		try {
			Server server = ServerBuilder.forPort(port)
			    .addService(smartcartservice)
			    .build()
			    .start();
			 
			CartDataStore.initializeCarts();

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
    public void addToCart(CartUpdateRequest request, StreamObserver<CartStatus> responseObserver) {
        String cartId = request.getCartId(); 
		String productId = request.getItemId(); 
		Cart c = CartDataStore.getCart(cartId);
		ItemInfo item = getProductFromInventory(productId);

		CartProduct cp = new CartProduct(item.getItemId(), item.getName(), item.getPrice(), 1);
		c.addProduct(cp);

		CartStatus reply = CartStatus.newBuilder().setSuccess(true).setMessage("Item added to cart.").build();
	     
		responseObserver.onNext(reply);
	     
	    responseObserver.onCompleted();
    }

    @Override
    public void getCartContents(CartRequest request, StreamObserver<CartContents> responseObserver) {
        String cartId = request.getCartId(); 
		Cart c = CartDataStore.getCart(cartId);

		
		float totalCost = 0;
		for (CartProduct product : c.getProducts()) {
			totalCost += product.getPrice() * product.getQuantity();
			CartItem cartItem = CartItem.newBuilder().setItemId(product.getItemId()).setName(product.getName()).setPrice(product.getPrice()).setQuantity(product.getQuantity()).build();

			CartContents reply = CartContents.newBuilder().setCartId(cartId).setTotal(totalCost).setItem(cartItem).build();
			responseObserver.onNext(reply);
		}
	     
	    responseObserver.onCompleted();
    }

    @Override
    public void removeFromCart(CartUpdateRequest request, StreamObserver<CartStatus> responseObserver) {
        String cartId = request.getCartId(); 
		String productId = request.getItemId(); 
		Cart c = CartDataStore.getCart(cartId);

		CartStatus reply;	
		if(c.removeProduct(productId)){
		 	reply = CartStatus.newBuilder().setSuccess(true).setMessage("Item removed from cart.").build();
		} else {
			reply = CartStatus.newBuilder().setSuccess(false).setMessage("Item doesn't exist in cart.").build();
		}
	     
		responseObserver.onNext(reply);
	     
	    responseObserver.onCompleted();
    }

	private ItemInfo getProductFromInventory(String productId)
	{
		ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50051).usePlaintext().build();
        InventoryManagerBlockingStub blockingStub = InventoryManagerGrpc.newBlockingStub(channel);

        //preparing message to send
        ItemRequest request = ItemRequest.newBuilder().setItemId(productId).build();

        //retreving reply from service
        return blockingStub.getItemInfo(request);
	}
}
