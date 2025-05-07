package school.faang.bjs274661;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class OrderProcessor {

    private static final ExecutorService SERVICE = Executors.newFixedThreadPool(3);
    private final AtomicInteger totalProcessedOrders = new AtomicInteger(0);


    public CompletableFuture<Void> processOrder(Order order) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000);
                order.setStatus("Processed");
                totalProcessedOrders.incrementAndGet();
                System.out.println("Order: " + order.getId() + " is " + order.getStatus());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new IllegalArgumentException(e);
            }
            return null;
        }, SERVICE);
    }

    public void processAllOrders(List<Order> orders) {
        List<CompletableFuture<Void>> processedOrders = orders.stream()
                .map(order -> processOrder(order))
                .toList();
        CompletableFuture<Void> allOrders =
                CompletableFuture.allOf(processedOrders.toArray(new CompletableFuture[0]));
        allOrders.join();
    }
}
