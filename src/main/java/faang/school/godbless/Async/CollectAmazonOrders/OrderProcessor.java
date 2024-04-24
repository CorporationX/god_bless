package faang.school.godbless.Async.CollectAmazonOrders;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

public class OrderProcessor {
    private static AtomicInteger totalProcessedOrders = new AtomicInteger(0);
    public CompletableFuture<Void> processOrder(Order order) {
        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            order.setStatus("Processed");

            totalProcessedOrders.incrementAndGet();
        });

        return future;
    }

    public int getTotalProcessedOrders() {
        return totalProcessedOrders.get();
    }
}
