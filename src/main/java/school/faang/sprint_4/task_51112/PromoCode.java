package school.faang.sprint_4.task_51112;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Getter
@Slf4j
public class PromoCode {
    private final String code;
    private final double discount;
    private final LocalDateTime expirationDate;
    private final double minimumOrderValue;
    private boolean isUsed;

    public boolean isValidForOrder(Order order) {
        ValidationUtils.isNotNull(order, "Заказ");
        return !isUsed
                && order.getTotalPrice() >= minimumOrderValue
                && LocalDateTime.now().isBefore(expirationDate);
    }

    public synchronized void markAsUsed() {
        log.info("Промокод №{} использован", code);
        isUsed = true;
    }

    public String getInvalidReason(Order order) {
        if (isUsed) {
            return "Промокод уже использован";
        }
        if (LocalDateTime.now().isAfter(expirationDate)) {
            return "У промокода истек срок использования";
        }
        if (order.getTotalPrice() < minimumOrderValue) {
            return "Сумма заказа меньше минимальной суммы для использования промокода";
        }
        return null;
    }
}
