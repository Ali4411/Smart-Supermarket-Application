package data;

import java.util.ArrayList;
import java.util.List;

import grpc.services.smartcart.CartItem;

public class Cart {
    private String cartId;
    private List<CartItem> cartItems;

    // Constructor to initialize the cart with an ID and an empty product list
    public Cart(String cartId) {
        this.cartId = cartId;
        this.cartItems = new ArrayList<>();
    }

    // Method to add a product to the cart
    public void addProduct(CartItem product) {
        cartItems.add(product);
    }

    // Method to remove a product from the cart by ID
    public boolean removeProduct(String productId) {
        for (CartItem product : cartItems) {
            if (product.getItemId() == productId) {
                cartItems.remove(product);
                return true;
            }
        }
        return false;
    }

    // Method to calculate the total cost of the products in the cart
    public float calculateTotalCost() {
        float totalCost = 0;
        for (CartItem product : cartItems) {
            totalCost += product.getPrice();
        }
        return totalCost;
    }

    // Getters and Setters
    public String getCartId() {
        return cartId;
    }

    public void setCartId(String cartId) {
        this.cartId = cartId;
    }

    public List<CartItem> getProducts() {
        return cartItems;
    }

    public void setProducts(List<CartItem> products) {
        this.cartItems = products;
    }

}
