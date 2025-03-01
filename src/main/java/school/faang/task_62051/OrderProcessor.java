package school.faang.task_62051;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class OrderProcessor {
    private static final int TIME_MILLISECONDS = 1000;
    private final AtomicInteger totalProcessedOrders = new AtomicInteger(0);

    public CompletableFuture<Void> processOrder(Order order) {
        return CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(TIME_MILLISECONDS);
            } catch (InterruptedException e) {
                log.error("Поток был прерван: {}", e.getMessage(), e);
                throw new RuntimeException("Поток был прерван: " + e.getMessage(), e);
            }
            order.setStatus("Обработано");
            totalProcessedOrders.incrementAndGet();
        });
    }

    public void processAllOrders(List<Order> orders) {
        List<CompletableFuture<Void>> futures = orders.stream()
                .map(this::processOrder)
                .toList();
        // Ожидаем завершения всех CompletableFuture
        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]))
                .thenRun(() -> log.info("Обработано заказов: " + totalProcessedOrders.get()))
                .join();
        // После завершения всех задач выводим общее количество обработанных заказов
    }
}
