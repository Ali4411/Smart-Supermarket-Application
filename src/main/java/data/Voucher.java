package data;

public class Voucher {
    private String voucherCode;
    private int discountAmount;

    public Voucher(String voucherCode, int discountAmount) {
        this.voucherCode = voucherCode;
        this.discountAmount = discountAmount;
    }

    public String getVoucherCode() {
        return voucherCode;
    }

    public void setVoucherCode(String voucherCode) {
        this.voucherCode = voucherCode;
    }

    public int getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(int discountAmount) {
        this.discountAmount = discountAmount;
    }
}
