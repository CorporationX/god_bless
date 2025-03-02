package school.faang.amazon_orders;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class OrderProcessor {
    private static final AtomicInteger totalProcessedOrders = new AtomicInteger();
    private final int processingTime = 3000;

    public CompletableFuture<Void> processOrder(Order order) {
        return CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(processingTime);
                order.setStatus(OrderStatus.PROCESSED);
                totalProcessedOrders.incrementAndGet();
                log.info(String.format("Ордер %d успешно обработан.", order.getId()));
            } catch (InterruptedException e) {
                log.error("Ошибка при работе потока");
                Thread.currentThread().interrupt();
                log.error("Произошла ошибка", e);
                throw new RuntimeException(e);
            }
        });

    }

    public static int getTotalProcessedOrders() {
        return totalProcessedOrders.get();
    }
}
