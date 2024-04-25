package faang.school.godbless.BJS2_6135;

import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

@Getter
@Setter
public class OrderProcessor {
    private AtomicInteger totalProcessedOrders;

    public OrderProcessor() {
        this.totalProcessedOrders = new AtomicInteger();
    }

    public CompletableFuture<Void> processOrder(Order order) {
        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        totalProcessedOrders.incrementAndGet();
        return CompletableFuture.runAsync(() -> order.setStatus("done"));
    }
}
