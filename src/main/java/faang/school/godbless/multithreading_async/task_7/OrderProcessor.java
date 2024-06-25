package faang.school.godbless.multithreading_async.task_7;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class OrderProcessor {
    private final AtomicInteger totalProcessedOrders = new AtomicInteger(0);

    private void processOrder(Order order) {
        try {
            Thread.sleep(1000);
            order.setStatus(Status.SUCCESS);
            totalProcessedOrders.incrementAndGet();
        } catch (InterruptedException e) {
            order.setStatus(Status.ERROR);
            log.error("Order processing was interrupted for order ID: {}", order.getId(), e);
        }
    }

    public void processAllOrders(List<Order> orders, ExecutorService executor) {
        final List<CompletableFuture<Void>> completableFutures = orders.stream()
                .map(order -> CompletableFuture.runAsync(() -> processOrder(order), executor))
                .toList();
        final CompletableFuture<Void> allFutures = CompletableFuture.allOf(completableFutures.toArray(new CompletableFuture[0]));
        allFutures.join();
        log.info("Total processed orders: {}", totalProcessedOrders.get());
    }
}
