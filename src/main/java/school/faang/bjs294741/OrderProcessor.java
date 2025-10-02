package school.faang.bjs294741;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class OrderProcessor {

    private static final int PROCESSING_DELAY_MILLIS = 3000;

    AtomicInteger totalProcessedOrders = new AtomicInteger(0);

    public CompletableFuture<Void> processOrder(Order order) {
        return CompletableFuture.runAsync(() -> {
            try {
                System.out.println("Processing order with ID: " + order.getId());
                Thread.sleep(PROCESSING_DELAY_MILLIS);
                totalProcessedOrders.incrementAndGet();
                order.setStatus("Processed");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                log.error("Error processing order", e);
            }
        });
    }

    public void processAllOrders(List<Order> orders) {
        List<CompletableFuture<Void>> futures = orders.stream()
            .map(this::processOrder)
            .toList();

        CompletableFuture<Void> allOf = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));
        allOf.join();

        System.out.println("Total processed orders: " + totalProcessedOrders.get());
    }
}