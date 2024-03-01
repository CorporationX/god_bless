package faang.school.godbless.amazonorders;

import lombok.Getter;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

@Getter
public class OrderProcessor {
    private AtomicInteger totalProcessedOrders = new AtomicInteger(0);
    private final ExecutorService executorService = Executors.newCachedThreadPool();

    public CompletableFuture<Void> processOrder(Order order) {
        return CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            order.setStatus("Done");
            totalProcessedOrders.incrementAndGet();
        });

    }
}
