package school.faang.collect_orders_in_amazon;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class OrderProcessor {
    private final AtomicInteger totalProcessedOrders = new AtomicInteger(0);

    public CompletableFuture<Void> processOrder(Order order) {
        return CompletableFuture.runAsync(() -> {
            try {

                log.info("Начало обработки заказа #{}", order.getId());
                Thread.sleep(1000 + (long) (Math.random() * 2000)); // Случайная задержка 1-3 сек

                order.setStatus(" Обработано");
                totalProcessedOrders.incrementAndGet();

                log.info("Заказ #{} успешно обработан", order.getId());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                order.setStatus("Ошибка обработки");
                log.error("Ошибка при обработке заказа #{}: {}", order.getId(), e.getMessage());
            }
        });
    }

    public CompletableFuture<Void> processAllOrders(List<Order> orders) {
        if (orders == null || orders.isEmpty()) {
            log.info("Нет заказов для обработки");
            return CompletableFuture.completedFuture(null);
        }

        log.info("Обработка {} заказов...", orders.size());

        CompletableFuture<?>[] futures = orders.stream()
                .map(this::processOrder)
                .toArray(CompletableFuture[]::new);

        return CompletableFuture.allOf(futures)
                .thenRun(() -> log.info("Все заказы обработаны. Всего обработано: {}", getTotalProcessedOrders()));
    }

    public int getTotalProcessedOrders() {
        return totalProcessedOrders.get();
    }
}
