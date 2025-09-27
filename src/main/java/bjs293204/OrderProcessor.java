package bjs293204;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

public class OrderProcessor {
    private static final AtomicInteger totalProcessedOrders = new AtomicInteger(0);

    public static CompletableFuture<Order> processOrder(Order order) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
            order.setStatus(OrderStatus.PROCESSED);
            totalProcessedOrders.getAndIncrement();
            return order;
        });
    }

    public void processAllOrders(List<Order> orders) {
        List<CompletableFuture<Order>> ordersResults = orders.stream().map(OrderProcessor::processOrder).toList();
        CompletableFuture<Void> allOrders = CompletableFuture.allOf(ordersResults.toArray(new CompletableFuture[0]));
        allOrders.join();
        System.out.println("Processed orders amount: " + totalProcessedOrders.get());
    }
}
