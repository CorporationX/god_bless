package school.faang.discount;

import lombok.AllArgsConstructor;

import java.time.LocalDate;
import java.util.concurrent.atomic.AtomicBoolean;

@AllArgsConstructor
public class PromoCode {
    private int code;
    private double discount;
    private LocalDate expirationDate;
    private double minimumOrderValue;
    private final AtomicBoolean isUsed = new AtomicBoolean(false);

    public boolean isValidForOrder(Order order) {
        if (order.getTotalPrice() >= minimumOrderValue && LocalDate.now().isBefore(expirationDate) && !isUsed()) {
            return true;
        }
        return false;
    }

    public void markAsUsed() {
        isUsed.set(true);
    }

    public double getDiscount() {
        return discount;
    }

    public boolean isUsed() {
        return isUsed.get();
    }
}
