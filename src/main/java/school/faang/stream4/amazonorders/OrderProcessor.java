package school.faang.stream4.amazonorders;

import lombok.Getter;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

public class OrderProcessor {
    @Getter
    private AtomicInteger totalProcessedOrders = new AtomicInteger(0);

    public CompletableFuture<Order> processOrder(Order order) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1500);
                order.setStatus("Обработано");
                totalProcessedOrders.getAndIncrement();
                return order;
            } catch (InterruptedException e) {
                throw new RuntimeException("Ошибка при обработке заказа", e);
            }
        });
    }

    public CompletableFuture<List<Order>> processAllOrders(List<Order> orders) {
        List<CompletableFuture<Order>> futures = orders.stream()
                .map(this::processOrder)
                .toList();

        return CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]))
                .thenApply(v -> futures.stream()
                        .map(CompletableFuture::join)
                        .toList());
    }
}
