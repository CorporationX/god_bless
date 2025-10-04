package school.faang.bjs2_93202;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class OrderProcessor {
    private final AtomicInteger totalProcessedOrders = new AtomicInteger();
    private final ExecutorService ex = Executors.newFixedThreadPool(5);

    public CompletableFuture<Order> processOrder(Order order) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                log.info("Start processing order {}", order.getId());
                Thread.sleep(5_000L);
                order.setStatus("Processed");
                log.info("Order {} status has been set: {}", order.getId(), order.getStatus());
                totalProcessedOrders.incrementAndGet();
            } catch (InterruptedException e) {
                log.error("Interrupted while processing");
                Thread.currentThread().interrupt();
            }
            return order;
        }, ex);
    }

    public void processAllOrders(List<Order> orders) {
        List<CompletableFuture<Order>> futures = orders.stream()
                .map(this::processOrder)
                .toList();
        CompletableFuture.allOf(futures.toArray(new CompletableFuture[]{})).join();
        log.info("Total numbers of processes: {}", totalProcessedOrders.get());
    }

    public void exShutdown() {
        ex.shutdown();
        log.info("Executor service closed");
        try {
            if (!ex.awaitTermination(15, TimeUnit.SECONDS)) {
                log.error("Executor didn't terminate in time, shutting down");
                ex.shutdownNow();
            }
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }
}

