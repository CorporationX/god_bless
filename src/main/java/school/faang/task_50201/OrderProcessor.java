package school.faang.task_50201;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class OrderProcessor {
    private static final AtomicInteger totalProcessedOrders = new AtomicInteger();

    public CompletableFuture<Void> processOrder(Order order) {
        return CompletableFuture.runAsync(() -> {
            try {
                log.info("Order processing ID: {} is started", order.getId());
                Thread.sleep(1000);
                log.info("Order Processing ID: {} is finished", order.getId());
                totalProcessedOrders.incrementAndGet();
                order.orderDone();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                log.error("Order precessing ID: {} is interrupted", order.getId());
            }
        });
    }

    public void processAllOrders(List<Order> orders) {
        List<CompletableFuture<Void>> futures = orders.stream()
                .map(this::processOrder)
                .toList();

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]))
                .thenRun(() -> log.info("Orders processed: {}", totalProcessedOrders.get()))
                .join();
    }
}
