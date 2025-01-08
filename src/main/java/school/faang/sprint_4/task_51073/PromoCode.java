package school.faang.sprint_4.task_51073;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@RequiredArgsConstructor
@Getter
public class PromoCode {
    @NonNull
    private final String code;
    private final double discount;
    @NonNull
    private final LocalDate expirationDate;
    private final double minimumOrderValue;
    private boolean isUsed;

    public boolean isValidForOrder(Order order) {
        return LocalDate.now().isBefore(expirationDate)
                && order.getTotalPrice() < minimumOrderValue
                && !isUsed;
    }

    public void markAsUsed() {
        isUsed = true;
    }
}
