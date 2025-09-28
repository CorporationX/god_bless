package school.faang.bjs2_93194;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.List;


@Slf4j
public class OrderProcessor {
    private final AtomicInteger totalProcessedOrders = new AtomicInteger(0);
    private static final int TIME_SLEEP = 1000;

    public void processAllOrders(List<Order> orders) {
        CompletableFuture<?>[] futures = orders.stream()
                .map(this::processOrder)
                .toArray(CompletableFuture[]::new);

        CompletableFuture.allOf(futures).join();

        log.info("Всего обработано заказов: {}", totalProcessedOrders.get());
    }

    private CompletableFuture<Void> processOrder(Order order) {
        return CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(TIME_SLEEP);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                log.error("Обработка заказа {} прервана", order.getId());
                throw new RuntimeException(e);
            }
        })
                .thenRun(() -> order.setStatus(OrderStatus.PROCESSED))
                .thenRun(totalProcessedOrders::incrementAndGet)
                .thenRun(() -> log.info("Заказ {} обработан", order.getId()));
    }
}