package school.faang.BJS2_61967;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class OrderProcessor {
    private static final int ONE_SECOND_IN_MS = 1_000;

    AtomicInteger totalProcessedOrders = new AtomicInteger();

    public CompletableFuture<Void> processOrder(Order order) {
        return CompletableFuture.runAsync(() -> {
            order.setStatus(String.valueOf(Order.Status.NEW));
            log.debug("Производим операцию....Пожалуйста подождите! {}", order.getId());
            try {
                Thread.sleep(ONE_SECOND_IN_MS);

            } catch (InterruptedException e) {
                order.setStatus(String.valueOf(Order.Status.CANCELLED));
                log.debug("Операция отменена {}", +order.getId());
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
            order.setStatus(String.valueOf(Order.Status.PROCESSED));
            totalProcessedOrders.incrementAndGet();
            log.debug("Операция обработанна {}", order.getId());
        });
    }

    public int getTotalProcessedOrders() {
        return totalProcessedOrders.get();
    }
}
