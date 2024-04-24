package faang.school.godbless.amazon_orders;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

public class OrderProcessor {
    AtomicInteger totalProcessedOrders = new AtomicInteger(0);
    public CompletableFuture<Void> processOrder(Order order){
        return CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            totalProcessedOrders.incrementAndGet();
            order.setStatus("Обработано");
        });
    }
}
