package school.faang.sprint_4.task_50028;

import lombok.Getter;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

@Getter
public class OrderProcessor {
    private static final int ORDER_PROCESSING_TIME = 500;
    private final AtomicInteger totalProcessedOrders = new AtomicInteger(0);

    public CompletableFuture<Void> processOrder(Order order) {
        return CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(ORDER_PROCESSING_TIME);
                order.setStatus(OrderStatus.PROCESSED);
                totalProcessedOrders.incrementAndGet();
            } catch (InterruptedException e) {
                System.out.println("Order processing interrupted");
                Thread.currentThread().interrupt();
            }
        });
    }

    public List<CompletableFuture<Void>> processAllOrders(List<Order> orders) {
        return orders.stream()
                .map(this::processOrder)
                .toList();
    }
}
