package faang.school.godbless.kxnvg.amazon;

import lombok.Getter;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

@Getter
public class OrderProcessor {

    private AtomicInteger totalProcessedOrders;

    public OrderProcessor() {
        totalProcessedOrders = new AtomicInteger(0);
    }

    public CompletableFuture<Void> processOrder(Order order) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return CompletableFuture.runAsync(() -> {
            order.setStatus(Status.PROCESSED);
            totalProcessedOrders.incrementAndGet();
        });
    }
}
