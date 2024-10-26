package school.faang.deliverycoupons;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class PromoCode {
    private final String code;
    private final double discount;
    private final LocalDateTime expirationDate;
    private final double minimumOrderValue;
    private boolean isUsed;

    public boolean isValidForOrder(Order order) {
        double totalOrderValue = order.getTotalPrice();
        return !isUsed && expirationDate.isAfter(LocalDateTime.now()) && totalOrderValue >= minimumOrderValue;
    }

    public synchronized void markAsUsed() {
        isUsed = true;
    }
}

