package school.faangSprint4.t25;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class PromoCode {
    private final String code;
    private final double discount;
    private final LocalDate expirationDate;
    private final double minimumOrderValue;
    private volatile boolean isUsed;

    public PromoCode(String code, double discount, LocalDate expirationDate, double minimumOrderValue) {
        this.code = code;
        this.discount = discount;
        this.expirationDate = expirationDate;
        this.minimumOrderValue = minimumOrderValue;
        this.isUsed = false;
    }

    public synchronized boolean isValidForOrder(Order order) {
        return !isUsed &&
                LocalDate.now().isBefore(expirationDate) &&
                order.getTotalPrice() >= minimumOrderValue;
    }

    public synchronized boolean markAsUsed() {
        if (!isUsed) {
            isUsed = true;
            return true;
        }
        return false;
    }
}