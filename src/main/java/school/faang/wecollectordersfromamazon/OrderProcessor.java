package school.faang.wecollectordersfromamazon;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class OrderProcessor {
    private final AtomicInteger totalProcessedOrders = new AtomicInteger(0);

    public void processOrder(List<Order> orders) {
        List<CompletableFuture<Void>> futures = orders.stream()
                .map(order -> CompletableFuture.runAsync(() -> {
                    try {
                        Thread.sleep(1000);
                        order.setStatus(OrderStatus.PROCESSED);
                        totalProcessedOrders.incrementAndGet();
                    } catch (InterruptedException e) {
                        log.error("Ошибка! Поток был прирван во время ожидание ", e);
                        Thread.currentThread().interrupt();
                    }
                })).toList();

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();
        log.info("Обработано заказов {}", totalProcessedOrders.get());
    }
}
