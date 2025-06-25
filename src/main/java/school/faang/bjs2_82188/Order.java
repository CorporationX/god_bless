package school.faang.bjs2_82188;

import lombok.Getter;
import lombok.Setter;
import java.util.concurrent.atomic.AtomicInteger;

@Setter
public class Order {
    private static final AtomicInteger CURRENT_ID = new AtomicInteger(0);
    @Getter
    private final int id;
    private OrderStatus status;

    public Order() {
        this.id = CURRENT_ID.incrementAndGet();
        this.status = OrderStatus.CREATED;
    }
}
