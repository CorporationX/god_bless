package school.faang.bjs2_82188;

import lombok.Getter;

import java.util.concurrent.atomic.AtomicInteger;

@Getter
public class Order {
    private static AtomicInteger currentId = new AtomicInteger(0);
    private final int id;
    private OrderStatus status;

    public Order() {
        this.id = currentId.incrementAndGet();
        this.status = OrderStatus.CREATED;
    }

    public synchronized void setStatus(OrderStatus status) {
        this.status = status;
    }
}
