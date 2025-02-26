package school.faang.amazon;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

@Getter
@Slf4j
public class OrderProcessor {

    private static final long ORDER_PROCEED_TIME_IN_MS = 5000;

    private final AtomicInteger totalProcessedOrders = new AtomicInteger(0);

    public CompletableFuture<Void> processOrder(Order order) {
        return CompletableFuture.runAsync(() -> {
            try {
                order.updateStatus(StatusType.IN_PROCESS);
                log.info("Статус заказа {} обновлен до {}", order.getId(), order.getStatus());
                Thread.sleep(ORDER_PROCEED_TIME_IN_MS);
            } catch (InterruptedException e) {
                log.error("Поток прерван во время обработки заказа", e);
                throw new RuntimeException(e);
            }
            order.updateStatus(StatusType.DONE);
            log.info("Статус заказа {} обновлен до {}", order.getId(), order.getStatus());
            totalProcessedOrders.addAndGet(1);
        });
    }
}
