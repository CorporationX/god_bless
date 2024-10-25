package school.faang.processing_amazon_orders;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class OrderProcessor {
    private static final AtomicInteger TOTAL_PROCESSED_ORDERS = new AtomicInteger(0);
    private final ExecutorService executor;

    public OrderProcessor(int poolSize) {
        this.executor = Executors.newFixedThreadPool(poolSize);
    }

    private static void processOrder(Order order) {
        try {
            log.info("Starting processing order: " + order.getId());
            Thread.sleep(3000);
            order.setStatus(Status.PROCESSED);
            int processedCount = TOTAL_PROCESSED_ORDERS.incrementAndGet();
            log.info("Finished processing order " + order.getId() + ". Status is now " + order.getStatus() +
                    ". Total processed orders: " + processedCount);
        } catch (InterruptedException e) {
            log.error("Thread had been interrupted during processing order: " + order.getId(), e);
            Thread.currentThread().interrupt();
            throw new RuntimeException("Order processing was interrupted", e);
        }
    }

    public CompletableFuture<Order> startProcessOrder(Order order) {
        return CompletableFuture.supplyAsync(() -> {
            processOrder(order);
            return order;
        }, executor);
    }

    public void processAllOrders(List<Order> orders) {
        List<CompletableFuture<Order>> orderProcesses = orders.stream()
                .map(this::startProcessOrder)
                .toList();
        CompletableFuture<Void> allOf = CompletableFuture.allOf(orderProcesses.toArray(new CompletableFuture[0]));
        allOf.thenRun(() -> {
            log.info("All orders have been processed. Total processed orders: " + TOTAL_PROCESSED_ORDERS.get());
        }).exceptionally(ex -> {
            log.error("An error occurred while processing orders", ex);
            return null;
        });
        allOf.join();
    }

    public void shutdownExecutorService() {
        executor.shutdown();
        try {
            if (!executor.awaitTermination(30, TimeUnit.SECONDS)) {
                log.warn("Executor did not terminate in the specific time. Forcing shutdown...");
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("Executor shutdown was interrupted", e);
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}