package derschrank.sprint04.task25.bjstwo_51104.units;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class PromoCode {
    private static final int VALIDITY_MONTH = 3;
    private static final int DEFAULT_DISCOUNT = 10;
    private static final double DEFAULT_MINIMUM_ORDER = 0;

    private final String code;
    private final int discount;
    private final LocalDate expirationDate;
    private final double minimumOrderValue;
    private volatile boolean isUsed;
    private volatile Order isUsedForOrder;

    public PromoCode(String code) {
        this(code, DEFAULT_DISCOUNT, DEFAULT_MINIMUM_ORDER);
    }

    public PromoCode(String code, int discount, double minimumOrderValue) {
        this.code = code;
        this.discount = discount;
        this.minimumOrderValue = minimumOrderValue;
        this.expirationDate = getExpirationDate();
    }

    public synchronized boolean markAsUsed(Order order) {
        if (order != null && isValidForOrder(order)) {
            isUsedForOrder = order;
            isUsed = true;
            return true;
        }
        return false;
    }

    public boolean isValidForOrder(Order order) {
        return !isUsed
                && validDate()
                && order.getTotalPrice() >= minimumOrderValue;
    }

    private boolean validDate() {
        return LocalDate.now().isBefore(expirationDate);
    }

    private static LocalDate getExpirationDate() {
        return LocalDate.now().plusMonths(VALIDITY_MONTH);
    }

    @Override
    public String toString() {
        return String.format("#%s, discount: %d, expiration: %s, min: %.2f, used: %b",
                code, discount, expirationDate, minimumOrderValue, isUsed);
    }
}
