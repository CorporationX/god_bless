package faang.school.godbless.module.fourth.async.amazon;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
public class OrderProcessor {
    private final AtomicInteger totalProcessedOrders = new AtomicInteger();
    
    public CompletableFuture<Void> processOrder(Order order) {
        return CompletableFuture.runAsync(() -> {
            log.info("Processing order {}", order.getId());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            order.setStatus(Status.PROCESSED);
            totalProcessedOrders.incrementAndGet();
        });
    }
}
