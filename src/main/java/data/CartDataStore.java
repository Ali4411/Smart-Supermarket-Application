package data;

import java.util.ArrayList;
import java.util.List;

public class CartDataStore {

    private static List<Cart> carts;

    // Method to initialize the carts
    public static void initializeCarts() {
        carts = new ArrayList<>();
        carts.add(new Cart("cart_001"));
        carts.add(new Cart("cart_002" ));
        carts.add(new Cart("cart_003"));
        carts.add(new Cart("cart_004"));
        carts.add(new Cart("cart_005"));
    }

    public static Cart getCart(String cartId){
        for(Cart c:carts){
            if(c.getCartId().equals(cartId)){
                return c;
            }
        }
        return null;
    }

}
