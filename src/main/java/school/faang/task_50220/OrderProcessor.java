package school.faang.task_50220;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

public class OrderProcessor {

    private AtomicInteger totalProcessedOrders = new AtomicInteger(0);

    public void processAllOrders(List<Order> orders) {
        List<CompletableFuture<Order>> future = orders.stream()
                .map(this::processOrder)
                .toList();
        CompletableFuture.allOf(future.toArray(new CompletableFuture[0]))
                .thenRun(() -> System.out.println("Обработано заказов: " + totalProcessedOrders.get()))
                .join();
    }

    private CompletableFuture<Order> processOrder(Order order) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000);
                order.setStatus("Обработано");
                totalProcessedOrders.incrementAndGet();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return order;
        });
    }
}
