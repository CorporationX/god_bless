package BJS2_24736_CollectingAmazonOrders;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

@Getter
@Setter
@Slf4j
public class OrderProcessor {
    private AtomicInteger totalProcessedOrders = new AtomicInteger();

    public CompletableFuture<Void> processOrder(Order order) {
        return CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                log.error("Thread was interrupted!", e);
                Thread.currentThread().interrupt();
            }
            if (order.getStatus().equalsIgnoreCase("In progress")) {
                order.setStatus("Processed");
                totalProcessedOrders.incrementAndGet();
            } else if (order.getStatus().equalsIgnoreCase("Processed")) {
                log.warn("Order is already processed!");
            } else {
                log.warn("Unknown status! Please check order status!");
            }
        });
    }
}
