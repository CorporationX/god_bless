package school.faang.godbless.bjs2_38286;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class OrderProcessor {
    private static final int OPERATION_TIME = 3000;
    private static final int NUMBER_OF_THREADS = 8;

    private final AtomicInteger totalProcessedOrders = new AtomicInteger();

    public void processOrder(Order order) {
        try {
            Thread.sleep(OPERATION_TIME);
            order.setStatus("Processed");
            totalProcessedOrders.incrementAndGet();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("Thread {} interrupted when processing order {}", Thread.currentThread().getName(), order.getId());
        }
    }

    public void processAllOrders(List<Order> orders) {
        ExecutorService pool = Executors.newFixedThreadPool(NUMBER_OF_THREADS);
        List<CompletableFuture<Void>> futures = orders.stream()
                .map(order -> CompletableFuture.runAsync(() -> processOrder(order), pool))
                .toList();
        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();
        pool.shutdown();
        log.info("Total processed orders: {}", totalProcessedOrders.get());
    }
}
