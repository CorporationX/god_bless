package school.faang.amazoncollectingorders;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.io.Closeable;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
@Getter
public class OrderProcessor implements Closeable {
    private static final int SLEEP_TIME = 2000;
    private static final int THREAD_COUNT = 4;
    private final ExecutorService executor = Executors.newFixedThreadPool(THREAD_COUNT);
    private final AtomicInteger totalProcessedOrders = new AtomicInteger(0);

    public CompletableFuture<Void> processOrder(Order order) {
        log.info("Processing order...");
        return CompletableFuture.runAsync(() -> {
            order.setStatus("Processed");
            totalProcessedOrders.incrementAndGet();
            try {
                Thread.sleep(SLEEP_TIME);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                log.error("Thread was interrupted", e);
                throw new RuntimeException("Thread was interrupted", e);
            }
        }, executor);
    }

    public CompletableFuture<Void> processAllOrders(List<Order> orders) {
        List<CompletableFuture<Void>> futures = orders.stream()
                .map(this::processOrder)
                .toList();
        return CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));
    }

    @Override
    public void close() {
        executor.shutdown();
        try {
            if (!executor.awaitTermination(2, TimeUnit.SECONDS)) {
                log.info("Shutting down executor");
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("Thread was interrupted", e);
            throw new RuntimeException("Thread was interrupted", e);
        }
    }
}
