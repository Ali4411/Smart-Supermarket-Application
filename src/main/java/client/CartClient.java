package client;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import grpc.services.smartcart.CartContents;
import grpc.services.smartcart.CartItem;
import grpc.services.smartcart.CartRequest;
import grpc.services.smartcart.CartStatus;
import grpc.services.smartcart.CartUpdateRequest;
import grpc.services.smartcart.SmartCartGrpc;
import grpc.services.smartcart.SmartCartGrpc.SmartCartBlockingStub;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class CartClient {
    private static ManagedChannel cartChannel = ManagedChannelBuilder.forAddress("localhost", 50052).usePlaintext().build();
    private static SmartCartBlockingStub cartBlockingStub = SmartCartGrpc.newBlockingStub(cartChannel);

    public static CartStatus addToCart(String cartId, String itemId) {
        //preparing message to send
        CartUpdateRequest request4 = CartUpdateRequest.newBuilder().setCartId(cartId).setItemId(itemId).build();

        //retreving reply from service
        CartStatus response = cartBlockingStub.addToCart(request4);

        System.out.println("Message: " + response.getMessage());
        System.out.println("Success: " + response.getSuccess());
        System.out.println("--------------------------------");

        return response;
    }

    public static CartStatus removeFromCart(String cartId, String itemId) {
        //preparing message to send
        CartUpdateRequest request4 = CartUpdateRequest.newBuilder().setCartId(cartId).setItemId(itemId).build();

        //retreving reply from service
        CartStatus response = cartBlockingStub.removeFromCart(request4);

        System.out.println("Message: " + response.getMessage());
        System.out.println("Success: " + response.getSuccess());
        System.out.println("--------------------------------");

        return response;
    }

    public static List<CartItem> getCartContents(String cartId) {
        //preparing message to send
        CartRequest request6 = CartRequest.newBuilder().setCartId(cartId).build();

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
        
        return cartItems;
    }
}