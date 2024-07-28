package client;

import java.util.ArrayList;
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
import grpc.services.smartcart.CartItem;
import io.grpc.ManagedChannel;
import io.grpc.stub.StreamObserver;

public class CheckoutClient
{
    private float totalCheckoutCost;
    private List<CheckoutItem> itemsForCheckout;
    private ManagedChannel channel;

    public CheckoutClient(ManagedChannel channel) {
        this.channel = channel;
        totalCheckoutCost = 0;
        itemsForCheckout = new ArrayList<CheckoutItem>();
    }

    public float getTotalCheckoutCost() {
        return totalCheckoutCost;
    }

    public List<CheckoutItem> getItemsForCheckout() {
        return itemsForCheckout;
    }

    public void transferCart(List<CartItem> cartitems, String cartId) throws InterruptedException
    {
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
                System.out.println("Total cost is: " + totalCheckoutCost);
                System.out.println("--------------------------------");   
                finishLatch.countDown();
            }
        };

        StreamObserver<CheckoutRequest> requestObserver = CheckoutGrpc.newStub(channel).transferForCheckout(responseObserver);

        try {
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

    public VoucherResult applyVoucher(String cartId, String voucherCode)
    {
        CheckoutBlockingStub checkoutBlockingStub = CheckoutGrpc.newBlockingStub(channel);

        ApplyVoucher request = ApplyVoucher.newBuilder().setCartId(cartId).setVoucherCode(voucherCode).build();

        //retreving reply from service
        VoucherResult response = checkoutBlockingStub.applyDiscount(request);

        System.out.println("Message: " + response.getMessage());
        System.out.println("Success: " + response.getSuccess());
        System.out.println("Discount: " + response.getDiscountAmount());
        System.out.println("--------------------------------");

        return response;
    }

    public void completePayment(String cartId) throws InterruptedException
    {
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
            for (CheckoutItem ci : itemsForCheckout) {
                CheckoutItem item = CheckoutItem.newBuilder().setItemId(ci.getItemId()).setQuantity(ci.getQuantity()).build();
                CheckoutContents request = CheckoutContents.newBuilder().setCartId(cartId).setItem(item).setTotal(totalCheckoutCost).build();
                requestObserver.onNext(request);
                // Sleep for a bit before sending the next one.
                Thread.sleep(100);
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