package client;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import grpc.services.checkout.ApplyVoucher;
import grpc.services.checkout.CheckoutContents;
import grpc.services.checkout.CheckoutGrpc;
import grpc.services.checkout.CheckoutGrpc.CheckoutBlockingStub;
import grpc.services.checkout.CheckoutItem;
import grpc.services.checkout.CheckoutRequest;
import grpc.services.checkout.Receipt;
import grpc.services.checkout.VoucherResult;
import grpc.services.inventorymanagement.InventoryManagerGrpc;
import grpc.services.inventorymanagement.ItemRequest;
import grpc.services.inventorymanagement.Status;
import grpc.services.inventorymanagement.StockLevel;
import grpc.services.inventorymanagement.UpdateRequest;
import grpc.services.inventorymanagement.InventoryManagerGrpc.InventoryManagerBlockingStub;
import grpc.services.smartcart.CartContents;
import grpc.services.smartcart.CartItem;
import grpc.services.smartcart.CartRequest;
import grpc.services.smartcart.CartStatus;
import grpc.services.smartcart.CartUpdateRequest;
import grpc.services.smartcart.SmartCartGrpc;
import grpc.services.smartcart.SmartCartGrpc.SmartCartBlockingStub;
import grpc.services.inventorymanagement.ItemInfo;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

public class Client {
    public static void main(String[] args) {
        // Inventory
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50051).usePlaintext().build();
        InventoryManagerBlockingStub blockingStub = InventoryManagerGrpc.newBlockingStub(channel);

        // Inventory METHOD ONE //
        //preparing message to send
        ItemRequest request = ItemRequest.newBuilder().setItemId("item_003").build();

        //retreving reply from service
        StockLevel response = blockingStub.checkStock(request);

        System.out.println("The item ID is: " + response.getItemId());
        System.out.println("Its stock is: " + response.getQuantity());
        System.out.println("--------------------------------");
        

        // Inventory METHOD TWO //
        //preparing message to send
        ItemRequest request2 = ItemRequest.newBuilder().setItemId("item_003").build();

        //retreving reply from service
        ItemInfo response2 = blockingStub.getItemInfo(request2);

        System.out.println("Item ID is: " + response2.getItemId());
        System.out.println("Item name is: " + response2.getName());
        System.out.println("Item description is: " + response2.getDescription());
        System.out.println("Item price is: " + response2.getPrice());
        System.out.println("--------------------------------");


        // Inventory METHOD THREE //
        //preparing message to send
        UpdateRequest request3 = UpdateRequest.newBuilder().setItemId("item_002").setQuantity(2).build();

        //retreving reply from service
        Status response3 = blockingStub.updateStock(request3);

        System.out.println("Message: " + response3.getMessage());
        System.out.println("Success: " + response3.getSuccess());
        System.out.println("--------------------------------");

        // Smart cart
        ManagedChannel cartChannel = ManagedChannelBuilder.forAddress("localhost", 50052).usePlaintext().build();
        SmartCartBlockingStub cartBlockingStub = SmartCartGrpc.newBlockingStub(cartChannel);

        // Cart Methods One//
        //preparing message to send
        CartUpdateRequest request4 = CartUpdateRequest.newBuilder().setCartId("cart_002").setItemId("item_003").build();

        //retreving reply from service
        CartStatus response4 = cartBlockingStub.addToCart(request4);
        response4 = cartBlockingStub.addToCart(request4);
        response4 = cartBlockingStub.addToCart(request4);

        System.out.println("Message: " + response4.getMessage());
        System.out.println("Success: " + response4.getSuccess());
        System.out.println("--------------------------------");

         // Cart Methods Two//
        //preparing message to send
        CartUpdateRequest request5 = CartUpdateRequest.newBuilder().setCartId("cart_002").setItemId("item_003").build();

        //retreving reply from service
        CartStatus response5 = cartBlockingStub.removeFromCart(request5);

        System.out.println("Message: " + response5.getMessage());
        System.out.println("Success: " + response5.getSuccess());
        System.out.println("--------------------------------");

         // Cart Methods Three//
        //preparing message to send
        CartRequest request6 = CartRequest.newBuilder().setCartId("cart_002").build();

        //retreving reply from service
        List<CartItem> cartItems = new ArrayList<CartItem>();
        Iterator<CartContents> response6 = cartBlockingStub.getCartContents(request6);
        float totatCartCost = 0;
        while (response6.hasNext()) {
            CartContents cc = response6.next();
            System.out.println("Item ID is: " + cc.getItem().getItemId());
            System.out.println("Item name is: " + cc.getItem().getName());
            System.out.println("Item price is: " + cc.getItem().getPrice());
            System.out.println("Item quantity is: " + cc.getItem().getQuantity());
            cartItems.add(cc.getItem());
            totatCartCost = cc.getTotal();
        } 
        System.out.println("Total cost is: " + totatCartCost);
        System.out.println("--------------------------------");   


        System.out.println("Transferring cart for checkout"); 

        try {
            transferCart(cartItems, "cart_002");
            System.out.println("Total cost is: " + totalCheckoutCost);

        } catch (InterruptedException e) {
            System.out.println("InterruptedException durring transferCart"); 
        }
        System.out.println("--------------------------------");   

        applyVoucher("cart_002", "Save5");
        
        System.out.println("Processing payment"); 
        try {
            completePayment("cart_002");
        } catch (InterruptedException e) {
            System.out.println("InterruptedException durring transferCart"); 
        }


        //retreving reply from service
        response = blockingStub.checkStock(request);

        System.out.println("The item ID is: " + response.getItemId());
        System.out.println("Its stock is: " + response.getQuantity());
        System.out.println("--------------------------------");
    }

    static float totalCheckoutCost = 0;
    static List<CheckoutItem> itemsForCheckout = new ArrayList<CheckoutItem>();

    private static void transferCart(List<CartItem> cartitems, String cartId) throws InterruptedException
    {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50053).usePlaintext().build();
        final CountDownLatch finishLatch = new CountDownLatch(1);

        StreamObserver<CheckoutContents> responseObserver = new StreamObserver<CheckoutContents>() {
            @Override
            public void onNext(CheckoutContents contents) {
                totalCheckoutCost = contents.getTotal();
                itemsForCheckout.add(contents.getItem()); 
                System.out.println("Item ID is: " + contents.getItem().getItemId());
                System.out.println("Item name is: " + contents.getItem().getName());
                System.out.println("Item price is: " + contents.getItem().getPrice());
                System.out.println("Item quantity is: " + contents.getItem().getQuantity());
            }
            

            @Override
            public void onError(Throwable t) {
                finishLatch.countDown();
            }

            @Override
            public void onCompleted() {
                finishLatch.countDown();
            }
        };

        StreamObserver<CheckoutRequest> requestObserver = CheckoutGrpc.newStub(channel).transferForCheckout(responseObserver);

        try {
        // Send numPoints points randomly selected from the features list.
            for (CartItem ci : cartitems) {
                CheckoutItem item = CheckoutItem.newBuilder().setItemId(ci.getItemId()).setQuantity(ci.getQuantity()).build();
                CheckoutRequest request = CheckoutRequest.newBuilder().setCartId(cartId).setItem(item).build();
                requestObserver.onNext(request);
                // Sleep for a bit before sending the next one.
                Thread.sleep(500);
                if (finishLatch.getCount() == 0) {
                    // RPC completed or errored before we finished sending.
                    // Sending further requests won't error, but they will just be thrown away.
                    return;
                }
            }
        } catch (RuntimeException e) {
            // Cancel RPC
            requestObserver.onError(e);
            throw e;
        }
        // Mark the end of requests
        requestObserver.onCompleted();

        // Receiving happens asynchronously
        if (!finishLatch.await(1, TimeUnit.MINUTES)) {
            System.out.println("recordRoute can not finish within 1 minutes");
        }
    }

    private static void applyVoucher(String cartId, String voucherCode)
    {
        // Smart cart
        ManagedChannel checkoutChannel = ManagedChannelBuilder.forAddress("localhost", 50053).usePlaintext().build();
        CheckoutBlockingStub checkoutBlockingStub = CheckoutGrpc.newBlockingStub(checkoutChannel);

        ApplyVoucher request = ApplyVoucher.newBuilder().setCartId(cartId).setVoucherCode(voucherCode).build();

        //retreving reply from service
        VoucherResult response = checkoutBlockingStub.applyDiscount(request);

        System.out.println("Message: " + response.getMessage());
        System.out.println("Success: " + response.getSuccess());
        System.out.println("Discount: " + response.getDiscountAmount());
        System.out.println("--------------------------------");
    }

    private static void completePayment(String cartId) throws InterruptedException
    {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50053).usePlaintext().build();
        final CountDownLatch finishLatch = new CountDownLatch(1);

        StreamObserver<Receipt> responseObserver = new StreamObserver<Receipt>() {

            @Override
            public void onNext(Receipt reciept) {
                if(reciept.getSuccess()){
                    System.out.println("------RECIEPT-------");
                    System.out.println("Transaction ID: " + reciept.getTransactionId());
                    for(CheckoutItem item : reciept.getPurchasedItemsList()) {
                        System.out.println("Item ID is: " + item.getItemId());
                        System.out.println("Item name is: " + item.getName());
                        System.out.println("Item price is: " + item.getPrice());
                        System.out.println("Item quantity is: " + item.getQuantity());
                    }

                    System.out.println("Total Cost: " + reciept.getTotal());
                    System.out.println("------END RECIEPT-------");
                }
                else{
                    System.out.println("Error: " + reciept.getMessage());
                }
            }

            @Override
            public void onError(Throwable t) {
                finishLatch.countDown();
            }

            @Override
            public void onCompleted() {
                finishLatch.countDown();
            }
        };

        StreamObserver<CheckoutContents> requestObserver = CheckoutGrpc.newStub(channel).processPayment(responseObserver);

        try {
        // Send numPoints points randomly selected from the features list.
            for (CheckoutItem ci : itemsForCheckout) {
                CheckoutItem item = CheckoutItem.newBuilder().setItemId(ci.getItemId()).setQuantity(ci.getQuantity()).build();
                CheckoutContents request = CheckoutContents.newBuilder().setCartId(cartId).setItem(item).setTotal(totalCheckoutCost).build();
                requestObserver.onNext(request);
                // Sleep for a bit before sending the next one.
                Thread.sleep(500);
                if (finishLatch.getCount() == 0) {
                    // RPC completed or errored before we finished sending.
                    // Sending further requests won't error, but they will just be thrown away.
                    return;
                }
            }
        } catch (RuntimeException e) {
            // Cancel RPC
            requestObserver.onError(e);
            throw e;
        }
        // Mark the end of requests
        requestObserver.onCompleted();

        // Receiving happens asynchronously
        if (!finishLatch.await(1, TimeUnit.MINUTES)) {
            System.out.println("recordRoute can not finish within 1 minutes");
        }
    }
}
