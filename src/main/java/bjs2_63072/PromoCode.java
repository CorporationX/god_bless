package bjs2_63072;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicBoolean;

@Getter
@RequiredArgsConstructor
public class PromoCode {
    private final String code;
    private final double discount;
    private final LocalDateTime expirationDate;
    private final double minimumOrderValue;

    private final AtomicBoolean isUsed = new AtomicBoolean(false);

    public boolean isValidForOrder(Order order) {
        return order.getTotalPrice() >= minimumOrderValue
                && expirationDate.isAfter(LocalDateTime.now())
                && !isUsed.get();
    }

    public boolean markAsUsed() {
        // Код можно применить только 1 раз, и чтобы не вводить объект синхронизации сделаем так
        return isUsed.compareAndSet(false, true);
    }
}
