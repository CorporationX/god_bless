package school.faang.sprint_4.task_51094;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class PromoCode {
    private String code;
    private int discount;
    private LocalDate expirationDate;
    private BigDecimal minimumOrderValue;
    private boolean isUsed;

    public boolean isValidForOrder(@NonNull Order order) {
        return !isUsed
                && order.getPrice().compareTo(minimumOrderValue) > 0
                && !expirationDate.isBefore(LocalDate.now());
    }

    public void markAsUsed() {
        isUsed = true;
    }
}
