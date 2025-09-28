package school.faang.bjs2_93198;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

public class OrderProcessor {

    private final AtomicInteger totalProcessedOrders = new AtomicInteger(0);

    public CompletableFuture<Integer> processOrder(Order order) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                System.out.printf("Processing of order %s started.%n", order.getId());
                Thread.sleep(2000);
                System.out.printf("Order %s has been processed.%n", order.getId());
            } catch (InterruptedException e) {
                throw new RuntimeException("Order processing was interrupted: " + e);
            }
            order.setStatus(OrderStatus.PROCESSED);
            return totalProcessedOrders.incrementAndGet();
        });
    }
}
