package school.faang.module1.sprint4.ordersamazon;

import lombok.Data;

@Data
public class Order {
    private final int id;
    private OrderStatus status;

    public Order(int id) {
        this.id = id;
        this.status = OrderStatus.PENDING;
    }
}
