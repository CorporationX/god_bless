package school.faang.collectingordersamazon;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class OrderProcessor {
    private AtomicInteger totalProcessedOrders = new AtomicInteger(0);

    public CompletableFuture<Void> processOrder(Order order) {
        return CompletableFuture.runAsync(() -> {
            try {
                System.out.println("Processing order ID: " + order.getId());
                Thread.sleep(2000);
                order.setStatus("Processed");
                totalProcessedOrders.incrementAndGet();
                System.out.println("Order ID: " + order.getId() + " has been processed.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }

    public void processAllOrders(List<Order> orders) {
        List<CompletableFuture<Void>> futures = orders.stream()
                .map(this::processOrder)
                .collect(Collectors.toList());

        CompletableFuture<Void> allTasks = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));

        allTasks.thenRun(() -> System.out.println("Total processed orders: " + totalProcessedOrders.get()))
                .join();
    }
}