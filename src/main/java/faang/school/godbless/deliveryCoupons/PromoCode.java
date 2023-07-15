package faang.school.godbless.deliveryCoupons;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@AllArgsConstructor
@NoArgsConstructor

@Getter
@Setter
public class PromoCode {
    private String code;
    private double discount;
    private Instant expirationDate;
    private double minimumOrderValue;
    private boolean isUsed;

    public boolean isValidForOrder(Order order) {
        return !isUsed && order.getTotalPrice() >= minimumOrderValue && Instant.now().isBefore(expirationDate);
    }

    public synchronized void markAsUsed() {
        if (!isUsed) {
            isUsed = true;
        }
    }

}
