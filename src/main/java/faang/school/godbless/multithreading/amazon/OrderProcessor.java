package faang.school.godbless.multithreading.amazon;

import lombok.Getter;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

@Getter
public class OrderProcessor {
    private final AtomicInteger totalProcessedOrders = new AtomicInteger(0);

    public CompletableFuture<Void> processOrder (Order order){
        return CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(order.getOrderComplexity());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            order.setProcessed(true);
            totalProcessedOrders.incrementAndGet();
        });
    }
}
