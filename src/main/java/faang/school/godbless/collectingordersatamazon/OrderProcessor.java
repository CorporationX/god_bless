package faang.school.godbless.collectingordersatamazon;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@Getter
@Slf4j
public class OrderProcessor {
    private final ExecutorService executorService;
    private final AtomicInteger totalProcessedOrders;

    public OrderProcessor() {
        this.executorService = Executors.newCachedThreadPool();
        this.totalProcessedOrders = new AtomicInteger(0);
    }

    public CompletableFuture<Void> processOrder(Order order) {
        return CompletableFuture.runAsync(() -> {
            log.info("Order {} is processing", order.getId());
            try {
                Thread.sleep(5000L);
            } catch (InterruptedException e) {
                log.error("Order processing interrupted", e);
                Thread.currentThread().interrupt();
            }
            order.setStatus(Status.PROCESSED);
            totalProcessedOrders.incrementAndGet();
            log.info("Order {} processed", order.getId());
        }, executorService).exceptionally(throwable -> {
            log.error("Failed to process order {}: {}", order.getId(), throwable.getMessage());
            return null;
        });
    }

    public void shutdown() {
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(60, TimeUnit.SECONDS)) {
                log.warn("Executor did not terminate in the specified time.");
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("Shutdown interrupted", e);
            executorService.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}