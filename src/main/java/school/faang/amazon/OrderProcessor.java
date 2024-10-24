package school.faang.amazon;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class OrderProcessor implements AutoCloseable {

    private static final int MAX_PROCESSING_TIME = 5_000;

    private final AtomicInteger totalProcessedOrders = new AtomicInteger(0);
    private final ExecutorService executor = Executors.newCachedThreadPool();
    private final Random random = new Random();

    public CompletableFuture<Void> processAllOrders(List<Order> orders) {
        Objects.requireNonNull(orders, "Orders list cannot be null");
        return CompletableFuture.allOf(orders.stream().map(this::processOrder).toArray(CompletableFuture[]::new));
    }

    private CompletableFuture<Void> processOrder(Order order) {
        return CompletableFuture.runAsync(() -> {
            log.info("Processing order {}", order.getId());
            try {
                Thread.sleep(random.nextInt(MAX_PROCESSING_TIME));
            } catch (InterruptedException e) {
                log.error("Caught exception", e);
                throw new IllegalStateException(
                        String.format("Thread %s interrupted", Thread.currentThread().getName()), e
                );
            }
            order.setStatus(Order.Status.DONE);
            totalProcessedOrders.addAndGet(1);
            log.info("Processed order {}", order.getId());
        }, executor);
    }

    @Override
    public void close() {
        executor.shutdown();
        try {
            if (!executor.awaitTermination(1, TimeUnit.MINUTES)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }
    }

    public int getTotalProcessedOrders() {
        return totalProcessedOrders.get();
    }
}
