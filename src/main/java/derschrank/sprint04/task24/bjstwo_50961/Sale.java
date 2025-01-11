package derschrank.sprint04.task24.bjstwo_50961;

import java.time.LocalDate;

public record Sale(
        int productId,
        LocalDate timestamp,
        int quantity
) {
    @Override
    public String toString() {
        return String.format("Art. %d on %s, quantity: %d", productId, timestamp, quantity);
    }
}
