package school.faang.bjs294741;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class OrderProcessor {

    AtomicInteger totalProcessedOrders = new AtomicInteger(0);

    public void processOrder(Order order) throws InterruptedException {
        System.out.println("Processing order with ID: " + order.getId());
        Thread.sleep(3000);
        totalProcessedOrders.incrementAndGet();
        order.setStatus("Processed");
    }

    public void processAllOrders(List<Order> orders) {
        CompletableFuture.allOf(orders.stream()
            .map(order -> CompletableFuture.runAsync(() -> {
                try {
                    processOrder(order);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    log.error("Error processing order", e);
                }
            })).toArray(CompletableFuture[]::new))
            .join();

        System.out.println("Total processed orders: " + totalProcessedOrders.get());
    }
}