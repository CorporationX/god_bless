package delivery_coupons;

import lombok.Data;

import java.time.LocalDate;

@Data
public class PromoCode {
    private String code;
    private int discount;
    private int expirationDate;
    private double minimumOrderValue;
    private boolean isUsed;

    public PromoCode(String code, int discount, int expirationDate, double minimumOrderValue) {
        this.code = code;
        this.discount = discount;
        this.expirationDate = expirationDate;
        this.minimumOrderValue = minimumOrderValue;
        this.isUsed = false;
    }

    public boolean isValidForOrder(Order order) {
        if (this.isUsed && LocalDate.now().getYear() > this.expirationDate
                && order.getTotalPrice() < this.minimumOrderValue) {
            return false;
        }
        return true;
    }

    public synchronized boolean setIsUsed() {
        if (!this.isUsed) {
            this.isUsed = true;
            return true;
        }
        return false;
    }
}
