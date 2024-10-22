package bjs2_37874;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

public class OrderProcessor {
    private AtomicInteger totalProcessedOrders = new AtomicInteger(0);

    public void processAllOrders(List<Order> orders) {
        List<CompletableFuture<Void>> ordersFutures = orders.stream().map(this::processOrder).toList();
        CompletableFuture.allOf(ordersFutures.toArray(new CompletableFuture[0])).join();
        System.out.println("Processed all orders! Total processed orders: " + totalProcessedOrders);
    }

    public CompletableFuture<Void> processOrder(Order order) {
        return CompletableFuture.runAsync(() -> {
            try {
                long millisToSleep = 1000;
                Thread.sleep(millisToSleep);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            order.setStatus("Processed");
            totalProcessedOrders.getAndIncrement();
        });
    }
}
