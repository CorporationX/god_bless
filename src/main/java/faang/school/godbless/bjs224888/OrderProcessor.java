package faang.school.godbless.bjs224888;

import lombok.Data;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

@Data
public class OrderProcessor {
    private AtomicInteger totalProcessedOrders = new AtomicInteger(0);

    public CompletableFuture<Void> processOrder(Order order) {
        return CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep((new Random().nextInt(3) + 1) * 1000L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            order.setStatus("processed");
            totalProcessedOrders.getAndIncrement();
        });
    }
}