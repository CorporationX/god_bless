package school.faang.sprint_4.task_50951;

import lombok.ToString;

import java.time.LocalDateTime;

@ToString
public class Sales {
    private final int productId;
    private final LocalDateTime timestamp;
    private final int quantity;

    public Sales(int productId, int quantity) {
        this.productId = productId;
        this.timestamp = LocalDateTime.now();
        this.quantity = quantity;
    }
}
