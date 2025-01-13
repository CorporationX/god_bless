package school.faang.task_50308;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class OrderProcessor {
    private final AtomicInteger totalProcessedOrders = new AtomicInteger(0);

    public CompletableFuture<Void> processOrder(Order order) {
        return CompletableFuture.runAsync(() -> {
            try {
                System.out.println("Processing order " + order.getId());
                Thread.sleep(2000);
                order.setStatus("Обработано");
                totalProcessedOrders.incrementAndGet();
                System.out.println("Order " + order.getId() + " processed.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }

    public void processAllOrders(List<Order> orders) {
        List<CompletableFuture<Void>> futures = orders.stream()
                .map(this::processOrder)
                .toList();

        CompletableFuture<Void> allTasks = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));

        allTasks.thenRun(() -> {
            System.out.println("Обработано заказов: " + totalProcessedOrders.get());
        }).join();
    }
}