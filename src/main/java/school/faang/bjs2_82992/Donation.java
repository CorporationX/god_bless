package school.faang.bjs2_82992;

import lombok.Getter;
import java.util.concurrent.atomic.AtomicInteger;

@Getter
public class Donation {
    private static final AtomicInteger id = new AtomicInteger();
    private final double amount;

    public Donation(double amount) {
        id.incrementAndGet();
        this.amount = amount;
    }
}
