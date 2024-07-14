package data;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private String cartId;
    private List<CartProduct> cartItems;

    // Constructor to initialize the cart with an ID and an empty product list
    public Cart(String cartId) {
        this.cartId = cartId;
        this.cartItems = new ArrayList<>();
    }

    // Method to add a product to the cart
    public void addProduct(CartProduct product) {
        boolean exists = false;
        for (CartProduct currentProduct : cartItems) {
            if (currentProduct.getItemId().equals(product.getItemId())) {
                currentProduct.setQuantity(currentProduct.getQuantity() + 1);
                exists = true;
            }
        }
        if(!exists) {
            cartItems.add(product);
        }
    }

    // Method to remove a product from the cart by ID
    public boolean removeProduct(String productId) {
        for (CartProduct product : cartItems) {
            if (product.getItemId().equals(productId)) {
                int quantity = product.getQuantity();
                if(quantity > 1) {
                    product.setQuantity(quantity - 1);
                }
                else {
                    cartItems.remove(product);
                }
                return true;
            }
        }
        return false;
    }

    // Method to calculate the total cost of the products in the cart
    public float calculateTotalCost() {
        float totalCost = 0;
        for (CartProduct product : cartItems) {
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

    public List<CartProduct> getProducts() {
        return cartItems;
    }

    public void setProducts(List<CartProduct> products) {
        this.cartItems = products;
    }
}
