package school.faang.amazon2;

import lombok.Getter;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

@Getter
public class OrderProcessor {
    private final AtomicInteger totalProcessedOrders = new AtomicInteger(0);

    public CompletableFuture<Void> processOrder(Order order) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(order.getId() * 1000L);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
            order.setStatus("processed");
            return order;
        }).thenAccept(o -> totalProcessedOrders.incrementAndGet());
    }
}
