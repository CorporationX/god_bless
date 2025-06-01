package school.faang.bjs2_75681;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

@Getter
@Slf4j
public class OrderProcessor {
    public static final AtomicInteger totalProcessedOrders = new AtomicInteger();

    public CompletableFuture<Void> processOrder(Order order) {
        return CompletableFuture.runAsync(() -> {
            log.info("Начинаем собирать заказы, обрабатывается заказ № {} ", order.getId());
            try {
                Thread.sleep(5000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            order.setStatus(OrderStatus.PROCESSING);
            totalProcessedOrders.incrementAndGet();
            log.info("Заказ {} собран", order.getId());
        });
    }
}
