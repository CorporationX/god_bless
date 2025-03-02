package school.faang.task62113.service;

import lombok.Data;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

@Data
public class OrderProcessor {
    private AtomicInteger totalProcessedOrders = new AtomicInteger(0);

    public CompletableFuture<Void> processOrder(Order order) {
        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(5000);
                order.setStatus("Обработано");
                totalProcessedOrders.incrementAndGet();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException("Ошибка: " + e);
            }
        });
        return future;
    }

    public void processAllOrders(List<Order> orders) {
        List<CompletableFuture<Void>> futures = orders.stream()
                .map(order -> processOrder(order))
                .toList();
        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();
        System.out.println("Обработано заказов " + totalProcessedOrders.get());
    }
}
