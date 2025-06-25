package school.faang.module1.bjs2_82201;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicInteger;

import static school.faang.module1.bjs2_82201.OrderStatus.PROCESSED;

@Slf4j
public class OrderProcessor {

    private final AtomicInteger totalProcessedOrders = new AtomicInteger(0);
    private static final int TIMEOUT = 3000;

    public void processAllOrders(List<Order> orders, ExecutorService executor) {
        List<CompletableFuture<Void>> futures = orders.stream()
                .map(order -> processOrder(order, executor))
                .toList();
        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();
        log.info("Всего обработано заказов {}", totalProcessedOrders.get());
    }

    private CompletableFuture<Void> processOrder(Order order, ExecutorService executor) {
        return CompletableFuture.runAsync(() -> {
            try {
                log.info("Начинаем обрабатывать заказ {}, статус заказа: {}", order.getId(), order.getStatus());
                Thread.sleep(TIMEOUT);
                totalProcessedOrders.incrementAndGet();
                order.setStatus(PROCESSED);
                log.info("Заказ {} обработан, статус заказа: {}", order.getId(), order.getStatus());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                log.error("Поток был прерван", e);
                throw new RuntimeException(e);
            }
        }, executor);
    }
}