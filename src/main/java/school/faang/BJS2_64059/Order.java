package school.faang.BJS2_64059;

import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.atomic.AtomicInteger;

@Getter
public class Order {
    private static final AtomicInteger idCount = new AtomicInteger(0);
    private final int id;
    @Setter
    private String status;

    public Order() {
        this.id = idCount.getAndIncrement();
        this.status = "Новый";
    }
}
