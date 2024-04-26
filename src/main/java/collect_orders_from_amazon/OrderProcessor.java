package collect_orders_from_amazon;

import lombok.Getter;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

@Getter
public class OrderProcessor {
    private AtomicInteger totalProcessedOrders = new AtomicInteger();

    public CompletableFuture<Void> processOrder(Order order) {
        return CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(3000L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            order.setStatus("Обработано.");
            totalProcessedOrders.incrementAndGet();
        });
    }
}
