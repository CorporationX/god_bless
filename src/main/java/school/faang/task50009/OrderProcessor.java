package school.faang.task50009;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class OrderProcessor {
    private static final int TIME_SLEEP = 2;

    private final AtomicInteger totalProcessedOrders = new AtomicInteger(0);

    public void processOrders(List<Order> orders) {
        Objects.requireNonNull(orders);

        CompletableFuture
                .allOf(orders.stream()
                        .parallel()
                        .map(order -> CompletableFuture.runAsync(() -> {
                            try {
                                TimeUnit.SECONDS.sleep(TIME_SLEEP);
                            } catch (InterruptedException e) {
                                Thread.currentThread().interrupt();
                                log.info("Произошла ошибка при обработке ордера {}", order, e);
                            }

                            order.setStatus(Status.PROCESSED);

                            log.info("Ордер {} {}", order.getId(), order.getStatus());

                            totalProcessedOrders.getAndIncrement();
                        }))
                        .toArray(CompletableFuture[]::new))
                .join();

        log.info("Заказов обработано: {}", totalProcessedOrders.intValue());
    }
}
