package school.faang.amazon;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

public class OrderProcessor {
    private final AtomicInteger totalProcessedOrders = new AtomicInteger(0);

    public CompletableFuture<Void> processOrder(Order order) {
        return CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(1000);
                order.setStatus("Completed");
                totalProcessedOrders.incrementAndGet();
            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }
        });
    }

    public void processAllOrders(List<Order> orders) {
        List<CompletableFuture<Void>> future = orders
                .stream()
                .map(this::processOrder)
                .toList();

        CompletableFuture<Void> allOrders = CompletableFuture.allOf(future.toArray(new CompletableFuture[0]));
        allOrders.join();
        allOrders.thenRun(() -> System.out.println("Completed orders: " + totalProcessedOrders.get()));
    }
}
