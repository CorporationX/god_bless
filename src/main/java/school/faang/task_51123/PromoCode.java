package school.faang.task_51123;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;

@ToString
@Slf4j
@Getter
@RequiredArgsConstructor
public class PromoCode {
    private final UUID promoCodeId = UUID.randomUUID();
    private final String code;
    private final double discount;
    private final LocalDate expirationDate;
    private final double minimumOrderValue;
    private final AtomicBoolean isUsed = new AtomicBoolean(false);

    public boolean isValidForOrder(Order order) {
        return !isUsed.get() && LocalDate.now().isBefore(expirationDate)
                && order.getTotalPrice() >= minimumOrderValue;
    }

    public void markAsUsed() {
        isUsed.set(true);
    }
}
