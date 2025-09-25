package school.faang.multithreading.async.bjs2_93192;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class OrderProcessor {
    private static final long DELAY_OPERATION = 2000;

    private final AtomicInteger totalProcessedOrders = new AtomicInteger(0);

    public CompletableFuture<Order> processOrder(Order order) {
        try {
            log.info("Cтатус {} заказа: {}", order.getId(), order.getStatus());
            Thread.sleep(DELAY_OPERATION);
            order.statusChange(order, OrderStatus.PROCESSED);
            log.info("Новый статус {} заказа: {}", order.getId(), order.getStatus());
            totalProcessedOrders.incrementAndGet();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return CompletableFuture.completedFuture(order);
    }

    public void processAllOrders(List<Order> orders) {
        List<CompletableFuture<Order>> futures = orders.stream()
                .map(order -> processOrder(order))
                .toList();

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));

        log.info("Количество обработанных заказов: {}", totalProcessedOrders.get());
    }
}
