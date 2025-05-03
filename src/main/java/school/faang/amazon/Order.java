package school.faang.amazon;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Order {
    private final int id;
    private OrderStatus status;

    public void updateStatus(OrderStatus status) {
        this.status = status;
    }
}
