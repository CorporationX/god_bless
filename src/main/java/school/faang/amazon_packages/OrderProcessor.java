package school.faang.amazon_packages;

import lombok.Data;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@Data
public class OrderProcessor {
    private static final AtomicInteger totalProcessedOrders = new AtomicInteger(0);

    public CompletableFuture<Order> processOrder(Order order) {
        return CompletableFuture
                .runAsync(() -> {}, CompletableFuture.delayedExecutor(2, TimeUnit.SECONDS))
                .thenApplyAsync(v -> {
                    order.setStatus(OrderStatus.PROCESSED);
                    totalProcessedOrders.incrementAndGet();
                    return order;
                });
    }

    public int getTotalProcessedOrders() {
        return totalProcessedOrders.get();
    }
}

