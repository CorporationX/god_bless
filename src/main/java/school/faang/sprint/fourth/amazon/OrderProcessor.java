package school.faang.sprint.fourth.amazon;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class OrderProcessor {
    private static final int THREAD_SLEEP_TIME = 500;
    private static final int THREAD_COUNT = 3;
    private static final int AWAIT_TERMINATION_TIME = THREAD_SLEEP_TIME * THREAD_COUNT + THREAD_SLEEP_TIME;
    private final AtomicInteger totalProcessedOrders = new AtomicInteger(0);
    private final ExecutorService executor = Executors.newFixedThreadPool(THREAD_COUNT);

    public void processAllOrders(@NonNull List<Order> orders) {
        List<CompletableFuture<Void>> completableFutures = orders.parallelStream()
                .map(this::processOrder).toList();

        CompletableFuture.allOf(completableFutures.toArray(new CompletableFuture[0])).join();

        log.info("Total processed orders: {}", totalProcessedOrders.get());

        shutdown();
    }

    private CompletableFuture<Void> processOrder(@NonNull Order order) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(THREAD_SLEEP_TIME);
            } catch (InterruptedException e) {
                log.error("Thread sleep interrupted: {}", e.getMessage());
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
            totalProcessedOrders.incrementAndGet();
            return order;
        }, executor).thenAccept(orderForUpdate -> orderForUpdate.setStatus("Обработано"));
    }

    private void shutdown() {
        executor.shutdown();
        try {
            if (!executor.awaitTermination(AWAIT_TERMINATION_TIME, TimeUnit.MILLISECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("Thread wait interrupted: {}", e.getMessage());
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }
}
