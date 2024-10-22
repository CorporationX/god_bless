package bjs2_38088;

import lombok.Getter;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@Getter
public class OrderProcessor {
    private AtomicInteger totalProcessedOrders;

    public OrderProcessor() {
        totalProcessedOrders = new AtomicInteger(0);
    }

    public CompletableFuture<Order> processOrder(Order order) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.MILLISECONDS.sleep(500);
                order.setStatus(Status.DONE);
                totalProcessedOrders.incrementAndGet();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return order;
        });
    }
}
