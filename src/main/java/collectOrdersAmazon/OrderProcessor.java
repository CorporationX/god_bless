package collectOrdersAmazon;

import lombok.Getter;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

@Getter
public class OrderProcessor {
    private static final Random random = new Random();
    private AtomicInteger totalProcessedOrder = new AtomicInteger(0);

    public CompletableFuture<Order> processOrder(Order order) {
        if (order == null) {
            throw new NullPointerException("Order must be exist");
        }
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(random.nextInt(1000, 4000));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            order.setStatus("Processed");
            totalProcessedOrder.incrementAndGet();
            return order;
        });
    }
}


