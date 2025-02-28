package school.faang.amazon_orders;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Order {
    private final int id;
    private OrderStatus status;

    public void setStatus(OrderStatus status) {
        this.status = status;
    }
}
