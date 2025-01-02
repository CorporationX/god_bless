package school.faang.collectordersamazonbjs50169;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class OrderProcessor {
    private static final int PROCESSING_TIME_MS = 2000;
    private AtomicInteger totalProcessedOrders = new AtomicInteger(0);

    public CompletableFuture<Void> processOrder(Order order) {
        return CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(PROCESSING_TIME_MS);
                order.setStatus(OrderStatus.PROCESSED);
                int processedCount = totalProcessedOrders.incrementAndGet();
                log.info("The order with the ID {} has been processed. " +
                        "Total number of orders processed: {}", order.getId(), processedCount);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                log.error("Order processing has been interrupted", e);
            }
        });
    }

    public AtomicInteger getTotalProcessedOrders() {
        return totalProcessedOrders;
    }
}
