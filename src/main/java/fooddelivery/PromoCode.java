package fooddelivery;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;

@Data
@RequiredArgsConstructor
@Slf4j
public class PromoCode {
    private final String code;
    private final double discount;
    private final LocalDateTime expirationDate;
    private final double minimumOrderValue;
    private boolean isUsed = false;

    private final Object lock = new Object();

    public boolean isValidForOrder(Order order) {
        return !isUsed
                && order.getTotalPrice() >= minimumOrderValue
                && !LocalDateTime.now().isAfter(expirationDate);
    }

    public void markAsUsed() {
        if (isUsed) {
            throw new IllegalStateException("Promo code " + code + " has already been used.");
        }
        isUsed = true;
    }
}
