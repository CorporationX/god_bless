package school.faang.collect_orders_from_amazon;

import lombok.Data;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

@Data
public class OrderProcessor {
    private AtomicInteger totalProcessedOrders = new AtomicInteger(0);

    public Order processOrder(Order order) {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        totalProcessedOrders.addAndGet(1);
        return new Order(order.getId(), "Обработан");
    }

    public CompletableFuture<List<Order>> processAllOrders(List<Order> orders) {
        List<CompletableFuture<Order>> futures = orders.stream()
                .map(order -> CompletableFuture.supplyAsync(() -> processOrder(order)))
                .toList();

        return CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).thenApply(v ->
                futures.stream()
                        .map(CompletableFuture::join)
                        .toList());
    }
}
