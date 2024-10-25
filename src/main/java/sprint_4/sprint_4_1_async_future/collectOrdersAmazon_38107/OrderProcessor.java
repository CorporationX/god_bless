package sprint_4.sprint_4_1_async_future.collectOrdersAmazon_38107;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

import static sprint_4.sprint_4_1_async_future.collectOrdersAmazon_38107.OrderStatus.*;

@Slf4j
public class OrderProcessor {
    private static final int TIME_SLEEP_THREAD = 1000;

    private final AtomicInteger totalProcessedOrders;

    public OrderProcessor() {
        totalProcessedOrders = new AtomicInteger(0);
    }

    public void processAllOrders(List<Order> orders) {
        List<CompletableFuture<Void>> futures = orders.stream()
                .filter(order -> order.getStatus() != CANCELED)
                .map(this::processOrder)
                .toList();

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();
        log.info("Processed orders: {}", totalProcessedOrders.get());
    }

    public CompletableFuture<Void> processOrder(Order order) {
        return CompletableFuture.runAsync(() -> {
            sleepThread();
            order.setStatus(PROCESSED);
            totalProcessedOrders.incrementAndGet();
        });
    }

    private void sleepThread() {
        try {
            Thread.sleep(TIME_SLEEP_THREAD);
        } catch (InterruptedException e) {
            log.error("Error: {}", e.getMessage());
        }
    }
}
