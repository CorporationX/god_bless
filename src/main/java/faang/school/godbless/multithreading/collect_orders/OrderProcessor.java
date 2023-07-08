package faang.school.godbless.multithreading.collect_orders;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
public class OrderProcessor {
    private final AtomicInteger totalProcessedOrders;
    private final Random random;

    public OrderProcessor() {
        totalProcessedOrders = new AtomicInteger(0);
        random = new Random();
    }

    public CompletableFuture<Void> processOrder(Order order) {
        return CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(random.nextInt(100, 500));
            } catch (InterruptedException e) {
                log.error(e.getMessage());
            }
            order.setStatus(Order.Status.PROCESSED);
            totalProcessedOrders.incrementAndGet();
        });
    }
}
