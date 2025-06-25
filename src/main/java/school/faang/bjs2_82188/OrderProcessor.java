package school.faang.bjs2_82188;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
@AllArgsConstructor
public class OrderProcessor {
    private static final long OPERATION_TIME = 20_000;
    @Getter
    private static AtomicInteger totalProcessedOrders = new AtomicInteger(0);
    private final ExecutorService threadPool;

    public CompletableFuture<Void> processOrder(Order order) {
        return CompletableFuture.runAsync(() -> {
            try {
                log.info("Начали обработку заказа {}", order.getId());
                order.setStatus(OrderStatus.PROCESSING);
                Thread.sleep(OPERATION_TIME);
                order.setStatus(OrderStatus.PROCESSED);

                totalProcessedOrders.incrementAndGet();

                log.info("Заказ {} обработан", order.getId());
            } catch (InterruptedException e) {
                log.error("Поток был прерван. Заказ {} не обработан", order.getId(), e);
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
        }, threadPool);
    }
}
