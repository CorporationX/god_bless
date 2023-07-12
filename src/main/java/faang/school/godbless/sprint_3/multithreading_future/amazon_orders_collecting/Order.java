package faang.school.godbless.sprint_3.multithreading_future.amazon_orders_collecting;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Order {
    private int id;
    private OrderStatus status;

    public Order(int id) {
        this.id = id;
        status = OrderStatus.TO_DO;
    }
}