package school.faang.module1.bjs2_82201;

import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.atomic.AtomicInteger;

@Setter
@Getter
public class Order {
    private static final AtomicInteger COUNTER = new AtomicInteger();
    private final int id = COUNTER.incrementAndGet();
    private OrderStatus status;

    public Order(OrderStatus status) {
        this.status = status;
    }
}