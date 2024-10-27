package school.faang.amazon;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class OrderProcessor {
    private static final int NUM_THREADS = 5;
    private static final int ORDER_PROCESSING_TIME = 1000;
    private static final ExecutorService EXECUTOR = Executors.newFixedThreadPool(NUM_THREADS);
    private AtomicInteger totalProcessedOrders = new AtomicInteger(0);

    public CompletableFuture<Order> processOrder(Order order) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(ORDER_PROCESSING_TIME);
            } catch (InterruptedException e) {
                log.error("The current thread was interrupted during sleep: {}", e);
            }
            order.setStatus(OrderStatus.PROCESSED);
            totalProcessedOrders.getAndIncrement();
            return order;
        }, EXECUTOR);
    }

    public void processAllOrders(List<Order> orders) {
        List<CompletableFuture<Order>> allOrders = orders.stream()
                .map(this::processOrder)
                .toList();
        CompletableFuture<Void> allTasks = CompletableFuture.allOf(allOrders.toArray(CompletableFuture[]::new));
        allTasks.join();
        EXECUTOR.shutdown();
        log.info("Total number of orders processed: {}", totalProcessedOrders.get());
        log.info("Orders with the status \"Processed\": {}", orders);
    }
}
