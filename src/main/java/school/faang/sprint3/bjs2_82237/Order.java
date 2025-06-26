package school.faang.sprint3.bjs2_82237;


import lombok.Data;

import java.util.concurrent.atomic.AtomicInteger;

@Data
public class Order {
    public static AtomicInteger idGenerator = new AtomicInteger();
    private final int id;
    private OrderStatus status;

    public Order() {
        id = idGenerator.incrementAndGet();
        status = OrderStatus.NEW;
    }
}
