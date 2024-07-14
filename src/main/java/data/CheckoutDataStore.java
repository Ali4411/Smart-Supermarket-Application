package data;

import java.util.ArrayList;
import java.util.List;

public class CheckoutDataStore {
    private static List<Voucher> vouchers;
    private static List<CheckoutCart> cartsInCheckout;

    public static void initializeCheckout(){
        cartsInCheckout = new ArrayList<>();
        vouchers = new ArrayList<>();
        vouchers.add(new Voucher("Save5", 5));
        vouchers.add(new Voucher("Save10", 10));
        vouchers.add(new Voucher("Save15", 15));
        vouchers.add(new Voucher("Save20", 20));
    }

    // Method to get a vouvher based on its vouvher code
    public static Voucher getVoucher(String voucherCode){
        for (Voucher voucher : vouchers) {
            if (voucher.getVoucherCode().equals(voucherCode)) {
                return voucher;
            }
        }
        return null;
    }

    // Method to get a cart that is in the checkout
    public static CheckoutCart getCartInCheckout(String cartId){
        for (CheckoutCart cart : cartsInCheckout) {
            if (cart.getCartId().equals(cartId)) {
                return cart;
            }
        }
        return null;
    }

    public static void addCartToCheckout(CheckoutCart cart){
        cartsInCheckout.add(cart);
    }

    // Method to remove a product from the cart by ID
    public static boolean removeCartFromCheckout(String cartId) {
        for (CheckoutCart cart : cartsInCheckout) {
            if (cart.getCartId().equals(cartId)) {
                return cartsInCheckout.remove(cart);
            }
        }
        return false;
    }
}
