package data;

public class CheckoutCart extends Cart {
    
    private Voucher appliedVoucher;

    public CheckoutCart(String cartId) {
        super(cartId);
    }

    public Voucher getAppliedVoucher() {
        return appliedVoucher;
    }

    public void setAppliedVoucher(Voucher appliedVoucher) {
        this.appliedVoucher = appliedVoucher;
    }
}
