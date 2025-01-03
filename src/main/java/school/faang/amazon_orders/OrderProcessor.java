package school.faang.amazon_orders;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class OrderProcessor {
    private static final long THREAD_SLEEP_TIME = 2000L;
    @Getter
    private final AtomicInteger totalProcessedOrders = new AtomicInteger(0);

    public CompletableFuture<Void> processOrder(Order order) {
        return CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(THREAD_SLEEP_TIME);
                order.setStatus(OrderStatus.PROCESSED);
                totalProcessedOrders.incrementAndGet();
            } catch (InterruptedException e) {
                log.error("Thread {} was interrupted", Thread.currentThread().getName());
                Thread.currentThread().interrupt();
            } /*finally {
                order.setStatus(OrderStatus.CANCELLED);
            }*/
        });
    }
}
