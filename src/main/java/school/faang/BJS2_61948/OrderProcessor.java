package school.faang.BJS2_61948;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class OrderProcessor {
    private final ExecutorService executor = Executors.newFixedThreadPool(ConstAndMessages.NUM_THREADS);
    private final AtomicInteger totalProcessedOrders = new AtomicInteger(0);

    public CompletableFuture<Void> processOrder(Order order) {
        return CompletableFuture.runAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(ConstAndMessages.PROCESSED_TIMEOUT);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                log.error(ConstAndMessages.ERROR_IN_THE_THREAD, e);
                throw new RuntimeException(e);
            }
            order.setStatus(StatusType.PROCESSED);
            totalProcessedOrders.addAndGet(1);
            log.info(ConstAndMessages.CURRENT_PROCESSED_ORDER, order.getId());
        }, executor);
    }

    public void processAllOrders(List<Order> orders) {
        List<CompletableFuture<Void>> futures = orders.stream()
                .map(this::processOrder)
                .toList();
        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();
        log.info(ConstAndMessages.TOTAL_PROCESSED_ORDERS, totalProcessedOrders.get());
    }

    public void shutdown() {
        executor.shutdown();
        try {
            if (!executor.awaitTermination(ConstAndMessages.SHUTDOWN_TIMEOUT, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }
    }
}
