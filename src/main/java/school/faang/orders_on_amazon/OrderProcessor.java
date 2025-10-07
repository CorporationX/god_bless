package school.faang.orders_on_amazon;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Проект: god_bless
 * Класс OrderProcessor
 * Автор: Vital
 */

@Slf4j
public class OrderProcessor {
    private static final int PROCESSING_TIME_MS = 2000;
    private final AtomicInteger totalProcessedOrders = new AtomicInteger(0);

    public CompletableFuture<Void> processOrder(Order order) {
        Objects.requireNonNull(order, "Order cannot be null");

        return CompletableFuture.runAsync(() -> {
            try {
                log.info("Начинаем обработку заказа {}", order.getId());
                Thread.sleep(PROCESSING_TIME_MS);

                if (ThreadLocalRandom.current().nextInt(10) < 3) {
                    order.setStatus(OrderStatus.CANCELED);
                    log.warn("Заказ {} отменён", order.getId());
                } else {
                    order.setStatus(OrderStatus.PROCESSED);
                    int count = totalProcessedOrders.incrementAndGet();
                    log.info("Заказ {} обработан. Всего обработано: {}", order.getId(), count);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                log.error("Ошибка при обработке заказа {}", order.getId(), e);
            }
        });
    }

    public void processAllOrders(List<Order> orders) {
        Objects.requireNonNull(orders, "Orders list cannot be null");

        List<CompletableFuture<Void>> futures = orders.stream()
                .map(this::processOrder)
                .toList();

        CompletableFuture<Void> allDone = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));
        allDone.join();

        int total = getTotalProcessedOrders();
        log.info("Итоговое количество обработанных заказов: {}", total);
        System.out.println("Обработано заказов: " + total);
    }

    public int getTotalProcessedOrders() {
        return totalProcessedOrders.get();
    }
}