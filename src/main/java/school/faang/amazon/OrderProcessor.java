package school.faang.amazon;

import lombok.extern.java.Log;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

@Log
public class OrderProcessor {
    private static final int PROCESSING_DELAY_MS = 2000;
    private final AtomicInteger totalProcessedOrders = new AtomicInteger(0);

    public CompletableFuture<Void> processOrder(Order order) {
        return CompletableFuture.runAsync(() -> {
            try {
                log.info("Processing order ID: " + order.getId());
                Thread.sleep(PROCESSING_DELAY_MS);
                order.setStatus(OrderStatus.PROCESSED);
                totalProcessedOrders.incrementAndGet();
                log.info("Order ID " + order.getId() + " processed successfully");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                log.severe("Order processing interrupted " + e.getMessage());
                throw new RuntimeException(e);
            }
        });
    }

    public void processAllOrders(List<Order> orders) {
        List<CompletableFuture<Void>> futures = orders.stream()
                .map(this::processOrder)
                .toList();

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();

        log.info("Orders processed: " + totalProcessedOrders.get());
    }
}
