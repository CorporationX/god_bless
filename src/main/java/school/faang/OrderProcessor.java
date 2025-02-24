package school.faang;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
@Getter
public class OrderProcessor {
    private final AtomicInteger totalProcessedOrders = new AtomicInteger(0);

    public CompletableFuture<Order> processOrder(Order order, ExecutorService executor) {
        return CompletableFuture.supplyAsync(() -> {
            order.setStatus(Status.PENDING);
            log.info("Processing order: " + order.getId());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                order.setStatus(Status.FAILED);
                log.error("Order processing failed for: " + order.getId());
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
            order.setStatus(Status.CONFIRMED);
            totalProcessedOrders.incrementAndGet();
            log.info("order creation {} completed.", order.getId());
            return order;
        }, executor);
    }
}
