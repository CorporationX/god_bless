package school.faang.bjs2_61956;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class OrderProcessor {
    private static final int TRANSACTION_PROCESSING_TIME = 3;
    private static final String STATUS_NAME = "Processed";
    AtomicInteger totalProcessedOrders = new AtomicInteger(0);

    public CompletableFuture<Void> processedOrder(Order order) {
        return CompletableFuture.runAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(TRANSACTION_PROCESSING_TIME);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                log.error("Order processing interrupted. Order ID: {}. Reason: {}", order.getId(), e.getMessage(), e);
            }
            order.setStatus(STATUS_NAME);
            log.info("Order id: {}, status: {}, ", order.getId(), order.getStatus());
            totalProcessedOrders.incrementAndGet();
        });
    }

    public void processAllOrders(List<Order> orders) {
        List<CompletableFuture<Void>> futures = orders.stream()
                .map(this::processedOrder)
                .toList();
        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();

        int processedOrders = totalProcessedOrders.get();
        log.info("Total processed orders: {}", processedOrders);
    }
}
