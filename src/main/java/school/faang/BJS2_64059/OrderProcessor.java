package school.faang.BJS2_64059;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
@Getter
public class OrderProcessor {
    private final AtomicInteger totalProcessedOrders = new AtomicInteger(0);

    public CompletableFuture<Order> processOrder(Order order) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
                order.setStatus("Обработано");
                totalProcessedOrders.getAndIncrement();
                log.info("Заказ {} обработан", order.getId());
                return order;
            } catch (InterruptedException e) {
                log.error("Ошибка обработки заказа {}", order.getId(), e);
                Thread.currentThread().interrupt();
                throw new RuntimeException("Ошибка обработки заказа " + order.getId(), e);
            }

        });
    }
}
