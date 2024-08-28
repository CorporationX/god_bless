package amazon.storage;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class OrderProcessor {
    private static final int POOL_SIZE = 100;
    private final AtomicInteger totalProcessedOrders = new AtomicInteger(0);
    private final ExecutorService executor = Executors.newFixedThreadPool(POOL_SIZE);

    public CompletableFuture<Void> processOrder(@NonNull Order order) {
        return CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(ThreadLocalRandom.current().nextLong(5) * 500 + 1000L);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
            log.info("Processed order #" + order.getId());
            totalProcessedOrders.getAndIncrement();
            order.setStatus(OrderStatus.PROCESSED);
        }, executor);
    }

    public int getTotalProcessedOrders() {
        return totalProcessedOrders.get();
    }

    public void shutdown() {
        executor.shutdown();
    }
}
