package faang.school.godbless.async.amazon;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class OrderProcessor {

    private final AtomicInteger totalProcessedOrders = new AtomicInteger(0);

    public CompletableFuture<Void> processOrder(Order order) {
        return CompletableFuture.runAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                log.error(e.getMessage(), e);
            }
            order.setStatus("PROCESSED");
            totalProcessedOrders.incrementAndGet();
            log.info("Order {}: {}", order.getId(), order.getStatus());
        });
    }

    public int getTotalProcessedOrders() {
        return totalProcessedOrders.get();
    }
}
