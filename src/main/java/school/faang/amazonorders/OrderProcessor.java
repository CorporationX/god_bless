package school.faang.amazonorders;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class OrderProcessor {
    private static final AtomicInteger TOTAL_PROCESS_ORDERS = new AtomicInteger();
    private static final int ORDER_PROCESSING_TIME_MS = 3000;

    public void processAllOrders(List<Order> orders) {
        List<CompletableFuture<Order>> features = orders.stream()
                .map(order -> CompletableFuture.supplyAsync(() -> processOrder(order)))
                .toList();

        CompletableFuture.allOf(features.toArray(new CompletableFuture[0])).join();

        log.info("Обработано заказов: {}", features.size());
    }

    private Order processOrder(Order order) {
        try {
            log.info("Обработка заказа номер {}", order.getId());
            Thread.sleep(ORDER_PROCESSING_TIME_MS);
            log.info("Заказ номер {} обработан", order.getId());
            order.setStatus(Status.PROCESSED.getName());
            TOTAL_PROCESS_ORDERS.incrementAndGet();
            return order;
        } catch (InterruptedException e) {
            log.error("Поток прерван при обработке заказа {}: {}", order.getId(), e.getMessage(), e);
            throw new RuntimeException("Ошибка при обработке заказа " + order.getId(), e);
        }
    }
}
