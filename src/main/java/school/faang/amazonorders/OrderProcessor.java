package school.faang.amazonorders;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class OrderProcessor {
    private static final AtomicInteger TOTAL_PROCESS_ORDERS = new AtomicInteger();
    private static final int ORDER_PROCESSING_TIME = 3000;
    private static final String ORDER_PROCESSING_STATUS = "Обработано";

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
            Thread.sleep(ORDER_PROCESSING_TIME);
            log.info("Заказ номер {} обработан", order.getId());
            order.setStatus(ORDER_PROCESSING_STATUS);
            TOTAL_PROCESS_ORDERS.incrementAndGet();
            return order;
        } catch (InterruptedException e) {
            log.error("Поток прерван {}", e.getMessage(), e);
            throw new RuntimeException();
        }
    }
}
