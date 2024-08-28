package faang.school.godbless.BJS2_24726;

import lombok.Getter;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class OrderProcessor {
    private final Random random = new Random();
    @Getter
    private final AtomicInteger totalProcessedOrders = new AtomicInteger(0);

    public void processOrder(Order order) {
        try {
            Thread.sleep(1000L * (1 + random.nextInt(0, 5)));
        } catch (InterruptedException e) {
            throw new RuntimeException("Sleep error");
        }
        order.setStatus("PROCESSED");
        totalProcessedOrders.incrementAndGet();
    }
}

