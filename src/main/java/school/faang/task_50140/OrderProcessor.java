package school.faang.task_50140;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class OrderProcessor {
    private final AtomicInteger totalProcessedOrders;

    public OrderProcessor() {
        totalProcessedOrders = new AtomicInteger(0);
    }

    public CompletableFuture<Void> processOrder(@NonNull Order order) {
        return CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                log.error("Thread {} was interrupted while processing order: {}",
                        Thread.currentThread().getName(), order);
                order.setStatus(OrderStatus.CANCELED);
                throw new CompletionException(e);
            }
            order.setStatus(OrderStatus.PROCESSED);
            totalProcessedOrders.incrementAndGet();
        });

    }

    public void processAllOrders(@NonNull List<Order> orders) {
        List<CompletableFuture<Void>> futures = orders.stream()
                .filter(order -> order.getStatus() == OrderStatus.NEW)
                .map(this::processOrder)
                .toList();
        CompletableFuture.allOf(futures.toArray(CompletableFuture[]::new)).join();
        log.info("Total processed orders: {}", totalProcessedOrders);
    }

}
