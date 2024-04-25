package faang.school.godbless.collectingordersamazon;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
@Getter
public class OrderProcessor {
    private AtomicInteger totalProcessedOrders = new AtomicInteger(0);

    public CompletableFuture<Void> processOrder(Order order) {
        return CompletableFuture.runAsync(() -> {
            log.info("Order {} runAsync", order.getId());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                log.error(e.getMessage());
            }
            order.setStatus(Status.PROCESSED);
            totalProcessedOrders.incrementAndGet();
        });
    }
}
