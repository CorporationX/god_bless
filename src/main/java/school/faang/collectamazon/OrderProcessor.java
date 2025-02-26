package school.faang.collectamazon;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class OrderProcessor {
    private static final AtomicInteger TOTAL_PROCESSED_ORDERS = new AtomicInteger(0);

    public CompletableFuture<Void> processOrder(Order order) {
        return CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(2000);
                order.setStatus("Обработано!");
                TOTAL_PROCESSED_ORDERS.incrementAndGet();
            } catch (InterruptedException e) {
                log.info(e.getMessage(), e);
                Thread.currentThread().interrupt();
            }
        });
    }

    public List<CompletableFuture<Void>> processAllOrders(List<Order> orders) {
        return orders.stream()
                .map(this::processOrder)
                .toList();
    }
}
