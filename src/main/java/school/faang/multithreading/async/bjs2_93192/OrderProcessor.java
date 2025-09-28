package school.faang.multithreading.async.bjs2_93192;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class OrderProcessor {
    private static final long DELAY_OPERATION = 2000;

    private final AtomicInteger totalProcessedOrders = new AtomicInteger(0);

    public CompletableFuture<Void> processOrder(Order order) {
        return CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(DELAY_OPERATION);
                order.statusChange(order, OrderStatus.PROCESSED);
                log.info("Новый статус {} заказа: {}", order.getId(), order.getStatus());
                totalProcessedOrders.incrementAndGet();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException("Ошибка обработки заказа", e);
            }
        });
    }

    public void processAllOrders(List<Order> orders) {
        List<CompletableFuture<Void>> futures = orders.stream()
                .map(order -> processOrder(order))
                .toList();

        for (CompletableFuture<Void> future : futures) {
            future.join();
        }

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));

        log.info("Количество обработанных заказов: {}", totalProcessedOrders.get());
    }
}
