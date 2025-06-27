package school.faang.bjs2_82992;

import java.util.concurrent.atomic.AtomicInteger;

public record Donation(double amount) {
    private static final AtomicInteger id = new AtomicInteger();

    public Donation {
        id.incrementAndGet();
    }
}
