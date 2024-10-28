package school.faang.AmazonOrders;

import lombok.Data;

@Data
public class Order {
    private final int id;
    private OrderStatus status;

    public Order(int id) {
        this.id = id;
        this.status = OrderStatus.NEW;
    }
}
