package school.faang.amazon;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

public class OrderProcessor {
    AtomicInteger totalProcessedOrders = new AtomicInteger(0);

    public CompletableFuture<Order> processOrder(Order order) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
            order.setOrderStatus(OrderStatus.COMPLETE);
            totalProcessedOrders.incrementAndGet();
            return order;
        });
    }

    public void processAllOrders(List<Order> orders) {
        CompletableFuture<Order>[] cfs = orders.stream()
                .map(order -> processOrder(order)).toArray(CompletableFuture[]::new);

        CompletableFuture.allOf(cfs)
                .thenRun(() -> {
                    System.out.println(totalProcessedOrders.get());
                }).join();

    }
}
