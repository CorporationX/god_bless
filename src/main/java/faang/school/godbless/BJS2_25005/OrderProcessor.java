package faang.school.godbless.BJS2_25005;

import lombok.NoArgsConstructor;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicInteger;

@NoArgsConstructor
public class OrderProcessor {
    private final AtomicInteger totalProcessedOrders = new AtomicInteger(0);

    public int getTotalProcessedOrders() {
        return totalProcessedOrders.get();
    }

    public CompletableFuture<Void> processOrder(Order order, ExecutorService service) {
        return CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            order.setStatus("Processed");
            totalProcessedOrders.incrementAndGet();
        }, service);
    }
}
