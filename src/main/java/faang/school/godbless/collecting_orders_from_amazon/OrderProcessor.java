package faang.school.godbless.collecting_orders_from_amazon;

import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicInteger;
@Setter
@Getter
public class OrderProcessor {
    private AtomicInteger totalProcessorOrders;

    public OrderProcessor() {
        this.totalProcessorOrders = new AtomicInteger(0);
    }

    public CompletableFuture<Void> processOrder(Order order, ExecutorService executorService) {
        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            order.setStatus("processed");
            totalProcessorOrders.getAndIncrement();
        }, executorService);
        return future;
    }
}
