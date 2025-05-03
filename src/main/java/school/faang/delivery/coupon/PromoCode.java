package school.faang.delivery.coupon;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.concurrent.atomic.AtomicBoolean;

@Data
@Builder
public class PromoCode {
    private final String code;
    private final double discount;
    private final LocalDate expirationDate;
    private final double minimumOrderValue;
    private final AtomicBoolean isUsed = new AtomicBoolean(false);

    public boolean isValidForOrder(Order order) {
        return !isUsed.get()
                && LocalDate.now().isBefore(expirationDate)
                && order.getTotalPrice() >= minimumOrderValue;
    }

    public boolean markAsUsed() {
        return isUsed.compareAndSet(false, true);
    }
}
