package faang.school.godbless.AmazonOrders;

import lombok.Getter;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

@Getter
public class OrderProcessor {
    private AtomicInteger totalProcessedOrders = new AtomicInteger(0);

    public CompletableFuture<Integer> processOrder(Order order) {
        CompletableFuture<Integer> orderFuture = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            order.setStatus("Обработано");
            return totalProcessedOrders.incrementAndGet();
        });
        return orderFuture;
    }
}
