package faang.school.godbless.async.amazonOrders;

import lombok.Data;

@Data
public class Order {
    private int id;
    private OrderStatus status;

    public Order(int id) {
        this.id = id;
        status = OrderStatus.PUBLISHED;
    }

    public Order setStatus(OrderStatus status) {
        this.status = status;
        return this;
    }

    public OrderStatus getStatus() {
        return status;
    }
}
