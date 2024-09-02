package faang.school.godbless.sprint.four.amazon;

import lombok.Getter;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

@Getter
public class OrderProcessor {
    private final AtomicInteger totalProcessedOrders = new AtomicInteger(0);

    public CompletableFuture<Void> processOrder(Order order) {
        return CompletableFuture.runAsync(() -> {
            try {
                System.out.printf("Order with id: %d with status %s has been taken in work%n",
                        order.getId(), order.getStatus());
                Thread.sleep(3000);
                order.setStatus("PROCESSED");
                System.out.printf("Order with id: %d has been processed status set to %s%n",
                        order.getId(), order.getStatus());
                totalProcessedOrders.incrementAndGet();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
