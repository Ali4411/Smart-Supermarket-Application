package client;

import java.util.List;
import grpc.services.smartcart.CartItem;

public class Client {
    public static void main(String[] args) {
        // Inventory
        InventoryClient.CheckStock("item_003");
        InventoryClient.getItemInfo("item_003");
        InventoryClient.UpdateStock("item_003", 2);
        InventoryClient.CheckStock("item_003");

        String cartToUse = "cart_002";
        CartClient.addToCart(cartToUse, "item_003");
        CartClient.addToCart(cartToUse, "item_003");
        CartClient.addToCart(cartToUse, "item_003");
        CartClient.addToCart(cartToUse, "item_003");
        CartClient.addToCart(cartToUse, "item_002");
        CartClient.addToCart(cartToUse, "item_002");
        CartClient.addToCart(cartToUse, "item_005");

        CartClient.removeFromCart(cartToUse, "item_003");

        List<CartItem> cartItems = CartClient.getCartContents(cartToUse);

        System.out.println("Transferring cart for checkout"); 

        try {
            CheckoutClient.transferCart(cartItems, cartToUse);
        } catch (InterruptedException e) {
            System.out.println("InterruptedException durring transferCart"); 
        }

        CheckoutClient.applyVoucher(cartToUse, "Save5");
        
        System.out.println("Processing payment"); 
        try {
            CheckoutClient.completePayment(cartToUse);
        } catch (InterruptedException e) {
            System.out.println("InterruptedException durring transferCart"); 
        }


        //retreving reply from service
        InventoryClient.CheckStock("item_003");
        InventoryClient.CheckStock("item_002");
        InventoryClient.CheckStock("item_005");
    }
}
