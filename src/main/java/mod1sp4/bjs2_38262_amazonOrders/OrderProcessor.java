package mod1sp4.bjs2_38262_amazonOrders;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@Data
@Slf4j
@AllArgsConstructor
public class OrderProcessor {
    private final AtomicInteger totalProcessedOrders = new AtomicInteger(0);
    private static final long PROCESS_TIMEOUT = 7000L;
    private static final ExecutorService executor = Executors.newCachedThreadPool();

    public CompletableFuture<Void> processOrder(Order order) {
        return CompletableFuture.runAsync(() -> {
            simulationOfExecutionThreadSleep();
            order.setStatus(Status.PROCESSED);
            totalProcessedOrders.incrementAndGet();
        }, executor);
    }

    public void simulationOfExecutionThreadSleep() {
        try {
            Thread.sleep(PROCESS_TIMEOUT);
        } catch (InterruptedException e) {
            log.error("Thread was interrupted while thread was sleeping, message: {}", e.getMessage());
            throw new IllegalStateException(e);
        }
    }

    public void processAllOrders(List<Order> orders) {
        List<CompletableFuture<Void>> completableFutureList = orders.stream()
                .map(this::processOrder)
                .toList();

        CompletableFuture.allOf(completableFutureList.toArray(new CompletableFuture[0])).join();
        System.out.printf("\nCompleted orders %d", totalProcessedOrders.get());
    }

    public static void shuttingDownExecutor() {
        executor.shutdown();
        try {
            if (executor.awaitTermination(2, TimeUnit.MINUTES)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("Error shutting down executor: {}", e.getMessage());
            throw new IllegalStateException(e);
        }
    }
}
