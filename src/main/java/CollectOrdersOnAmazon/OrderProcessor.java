package CollectOrdersOnAmazon;

import lombok.NonNull;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

public class OrderProcessor {
    private final AtomicInteger totalProcessedOrders = new AtomicInteger(0);
    private final int TIME_ORDER = 3000;

    public CompletableFuture<Void> processOrder(@NonNull Order order) {
        return CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(TIME_ORDER);
                order.setStatus("Processed");
                totalProcessedOrders.incrementAndGet();
            } catch (InterruptedException e) {
                System.err.println("Thread was interrupted: " + e.getMessage());
            }
        });
    }

    public int getTotalProcessedOrders() {
        return totalProcessedOrders.get();
    }
}