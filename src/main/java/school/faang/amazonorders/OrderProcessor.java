package school.faang.amazonorders;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class OrderProcessor {
    private static final int ORDER_PROCESSING_DURATION = 1000;
    private final AtomicInteger totalProcessedOrders = new AtomicInteger(0);

    private CompletableFuture<Void> processOrder(Order order) {
        return CompletableFuture.runAsync(() -> {
            try {
                log.info("Идёт обработка заказа {}", order.getId());
                Thread.sleep(ORDER_PROCESSING_DURATION);
            } catch (InterruptedException e) {
                log.error("Обработка заказа {} прервана", order.getId());
                order.setStatus(OrderStatus.CANCELED);
                Thread.currentThread().interrupt();
            }
            order.setStatus(OrderStatus.PROCESSED);
            log.info("Заказ {} обработан", order.getId());
            totalProcessedOrders.incrementAndGet();
            log.info("Общее количество заказов: {}", totalProcessedOrders);
        });
    }

    public void processAllOrders(List<Order> orders) {
        List<CompletableFuture<Void>> futures = orders.stream()
                .map(this::processOrder)
                .toList();
        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]))
                .thenRun(() -> log.info("Всего обработано заказов: {}", totalProcessedOrders.get()))
                .join();
    }
}
