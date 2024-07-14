package data;

import java.util.ArrayList;
import java.util.List;

public class ProductDataStore {
    private static List<Product> products;

    // Method to initialize the product list with 5 products
    public static void initializeProducts() {
        products = new ArrayList<>();
        products.add(new Product("item_001", "Apple", "Fresh red apple", 0.50f, 100));
        products.add(new Product("item_002", "Banana", "Ripe yellow banana", 0.30f, 150));
        products.add(new Product("item_003", "Carrot", "Organic carrot", 6.20f, 200));
        products.add(new Product("item_004", "Milk", "1 liter of whole milk", 1.20f, 50));
        products.add(new Product("item_005", "Bread", "Whole grain bread", 2.50f, 30));
    }

    // Method to get the list of products
    public static List<Product> getProducts() {
        return products;
    }

    // Method to get a single product based on its ID
    public static Product getProduct(String id){
        for (Product product : products) {
            if (product.getId().equals(id)) {
                return product;
            }
        }
        return null;
    }

    // Method to update the stock of a product based on its ID and stock change
    public static void updateProductStock(String id, int stockChange) {
        Product product = getProduct(id);
        if (product != null) {
            product.setStock(product.getStock()+stockChange);
        }
    }
}
