package amazon;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

public class OrderProcessor {
    private AtomicInteger totalProcessedOrders = new AtomicInteger(0);

    public AtomicInteger getTotalProcessedOrders() {
        return totalProcessedOrders;
    }

    public CompletableFuture<Void> processOrder(Order order) {
       return CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            order.setStatus(OrderStatus.CANCELED);
            totalProcessedOrders.incrementAndGet();
        });
    }

}
