package school.faang.BJS2_61948;

import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.atomic.AtomicInteger;

@Getter
public class Order {
    private static final AtomicInteger currentId = new AtomicInteger(0);
    private final int id;
    @Setter
    private StatusType status;

    public Order() {
        id = currentId.addAndGet(1);
        status = StatusType.NEW;
    }

}
