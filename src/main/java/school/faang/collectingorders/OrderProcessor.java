package school.faang.collectingorders;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class OrderProcessor {
    private AtomicInteger totalProcessedOrders = new AtomicInteger(0);

    public CompletableFuture<Order> proccessOrder(Order order) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }

        CompletableFuture<Order> futureOrder = CompletableFuture.supplyAsync(() -> {
            order.setStatus("Обработано");
            totalProcessedOrders.incrementAndGet();
            return order;
        });

        return futureOrder;
    }

    public void proccessAllOrders(List<Order> orders) {
        List<CompletableFuture<Order>> futureOrderList = orders
                .stream()
                .map(this::proccessOrder)
                .toList();

        CompletableFuture.allOf(
                futureOrderList.toArray(new CompletableFuture[0])
        ).join();

        log.info("Обработано всего заказов: {}",
                totalProcessedOrders.get());
    }
}
