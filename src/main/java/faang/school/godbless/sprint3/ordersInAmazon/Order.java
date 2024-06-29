package faang.school.godbless.sprint3.ordersInAmazon;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Order {
    private int id;
    private OrderStatus status;
    private Object lock = new Object();

    public Order(int id, OrderStatus status) {
        this.id = id;
        this.status = status;
    }
}
