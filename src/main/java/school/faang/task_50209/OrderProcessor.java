package school.faang.task_50209;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
class OrderProcessor {
    private final AtomicInteger totalProcessedOrders = new AtomicInteger(0);

    public void processAllOrders(List<Order> orders) {
        CompletableFuture<?>[] futures = orders.stream()
                .map(this::processOrder)
                .toArray(CompletableFuture[]::new);

        CompletableFuture.allOf(futures).join();
        log.info("Обработано заказов: {}", totalProcessedOrders.get());
    }

    public CompletableFuture<Void> processOrder(Order order) {
        return CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(1000);
                order.setStatus(OrderStatus.PROCESSED);
                totalProcessedOrders.incrementAndGet();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                log.error("Ошибка при обработке заказа с ID {}", order.getId(), e);
            }
        });
    }
}

