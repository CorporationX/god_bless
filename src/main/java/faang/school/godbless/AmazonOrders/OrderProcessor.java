package faang.school.godbless.AmazonOrders;

import lombok.Data;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;
@Data
public class OrderProcessor {
    AtomicInteger totalProcessedOrders = new AtomicInteger(0);

    public CompletableFuture<Void> processedOrders(Order order) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
       return CompletableFuture.runAsync(() -> {
            order.setStatus(true);
            totalProcessedOrders.addAndGet(1);
        });

    }
}
