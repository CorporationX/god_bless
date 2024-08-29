package faang.school.godbless.task.multithreading.async.collect.amazon.orders;

import lombok.Getter;

@Getter
public class Order {
    private final long id;
    private OrderStatus status;

    public Order(long id) {
        this.id = id;
        this.status = OrderStatus.NOT_PROCESSED;
    }

    public void statusProcessed() {
        this.status = OrderStatus.PROCESSED;
    }
}
