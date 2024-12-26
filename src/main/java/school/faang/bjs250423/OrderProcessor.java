package school.faang.bjs250423;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

public class OrderProcessor {

    private AtomicInteger totalProcessedOrders = new AtomicInteger(0);


    public int processAllOrders(List<Order> orders) {
        List<CompletableFuture<Void>> futures = orders.stream()
                .map(this::processOrder)
                .toList();

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();
        return totalProcessedOrders.get();
    }

    private CompletableFuture<Void> processOrder(Order order) {
        return CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(10_000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
            order.setStatus("Processed");
            totalProcessedOrders.incrementAndGet();
            System.out.println("Order processed: " + order.getId());
        });
    }

}
