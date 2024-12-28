package school.faang.task_50111;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class OrderProcessor {
    private static final int THREAD_SLEEP = 1000;

    private final AtomicInteger totalProcessedOrders = new AtomicInteger(0);

    public CompletableFuture<Void> processOrder(Order order) {
        return CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(THREAD_SLEEP);
                order.setStatus(OrderStatus.InProcess);
                log.info("Начата обработка заказа {}. Статус: {}", order.getId(), order.getStatus());

                order.setStatus(OrderStatus.Completed);
                totalProcessedOrders.incrementAndGet();
                log.info("Заказ {} обработан. Статус: {}", order.getId(), order.getStatus());

            } catch (InterruptedException ex) {
                log.error("Ошибка обработки заказа {}: ", order.getId(), ex);
                Thread.currentThread().interrupt();
            } catch (IllegalStateException ex) {
                log.error("Невалидный переход статуса заказа {}", order.getId());
            }
        });
    }

    public void processAllOrders(List<Order> allOrders) {
        List<CompletableFuture<Void>> futures = allOrders.stream().map(this::processOrder).toList();

        CompletableFuture<Void> future = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));
        future.join();
        log.info("Обработано заказов: {}", totalProcessedOrders.get());

    }
}