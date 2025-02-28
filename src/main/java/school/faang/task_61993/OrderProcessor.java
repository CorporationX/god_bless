package school.faang.task_61993;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class OrderProcessor {
    private static final int THREAD_SLEEP = 10_000;
    private AtomicInteger totalProcessedOrders = new AtomicInteger(0);

    private CompletableFuture<Void> processOrder(Order order) {
        return CompletableFuture.runAsync(() -> {
            log.info("Order processing...");
            try {
                Thread.sleep(THREAD_SLEEP);
                order.setStatus(Status.PROCESSED);
                totalProcessedOrders.incrementAndGet();
            } catch (InterruptedException e) {
                order.setStatus(Status.FAILED);
                log.error("Sleep was interrupted");
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
        }).thenRun(() -> log.info("Order processing is finished"));
    }

    public void processAllOrders(List<Order> orders) {
        List<CompletableFuture<Void>> futures = orders.stream()
                .map(this::processOrder)
                .toList();

        CompletableFuture<Void> allOf = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));
        allOf.join();

        log.info("Number of orders processed: {}", totalProcessedOrders.get());
    }
}
