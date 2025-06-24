package school.faang.bjs2_82188;

import lombok.Getter;

@Getter
public class Order {
    private static int currentId;
    private final int id;
    private OrderStatus status;

    public Order() {
        this.id = ++currentId;
        this.status = OrderStatus.CREATED;
    }

    public synchronized void setStatus(OrderStatus status) {
        this.status = status;
    }
}
