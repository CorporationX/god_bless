package amazonorders;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class OrderProcessor {
    private static final int AVAILABLE_PROCESSORS = Runtime.getRuntime().availableProcessors();
    private static final int TERMINATION_TIMEOUT_SEC = 60;
    private static final int ORDER_PROCESSING_DELAY_SEC = 5;
    private static final ScheduledExecutorService EXECUTOR = Executors.newScheduledThreadPool(AVAILABLE_PROCESSORS);
    private final AtomicInteger totalProcessedOrders = new AtomicInteger(0);

    CompletableFuture<Void> processOrder(Order order) {
        CompletableFuture<Void> future = new CompletableFuture<>();
        log.info("Order {} initial status: {}", order.getId(), order.getStatus());
        EXECUTOR.schedule(() -> {
            try {
                order.setStatus(OrderStatus.PROCESSED);
                totalProcessedOrders.incrementAndGet();
                log.info("Order {} processed. New status: {}", order.getId(), order.getStatus());
                future.complete(null);
            } catch (Exception e) {
                order.setStatus(OrderStatus.FAILED);
                log.error("Error processing order {}. New status: {}", order.getId(), order.getStatus(), e);
                future.completeExceptionally(e);
            }
        }, ORDER_PROCESSING_DELAY_SEC, TimeUnit.SECONDS);
        return future;
    }

    void processAllOrders(List<Order> orders) {
        CompletableFuture.allOf(
                orders.stream()
                        .map(this::processOrder)
                        .toArray(CompletableFuture[]::new)
        ).join();

        log.info("Total processed orders: {}", totalProcessedOrders.get());
        shutdown();
    }

    private void shutdown() {
        EXECUTOR.shutdown();
        try {
            if (!EXECUTOR.awaitTermination(TERMINATION_TIMEOUT_SEC, TimeUnit.SECONDS)) {
                EXECUTOR.shutdownNow();
                if (!EXECUTOR.awaitTermination(TERMINATION_TIMEOUT_SEC, TimeUnit.SECONDS)) {
                    log.error("Unable to properly shut down the executor!");
                }
            }
        } catch (InterruptedException e) {
            log.error("Executor termination was interrupted.", e);
            EXECUTOR.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}
