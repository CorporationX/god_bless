package faang.school.godbless.amazonOrders;

import lombok.Getter;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

@Getter
public class OrderProcessor {
    private final AtomicInteger totalProcessedOrders = new AtomicInteger();

    public CompletableFuture<Void> processOrder(Order order) {
        return CompletableFuture.runAsync(() -> {
            System.out.println("Starting processing of order with id: " + order.getId());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                System.out.println("Order processing interrupted");
            }
            order.setStatus("Processed");
            totalProcessedOrders.incrementAndGet();
            System.out.println("Finished processing of order with id: " + order.getId());
        });
    }
}
