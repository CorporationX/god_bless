package faang.school.godbless.CollectAmazonOrders;

import lombok.RequiredArgsConstructor;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicInteger;

@RequiredArgsConstructor
public class OrderProcessor {
    private static final long PENDING_TIME = 2000L;
    private final AtomicInteger totalProcessedOrders = new AtomicInteger(0);
    private final ExecutorService pool;

    public CompletableFuture<Void> processOrder(Order order) {
        return CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(PENDING_TIME);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            order.setStatus(Status.PROCESSED);
            totalProcessedOrders.incrementAndGet();
            System.out.println(order.getId() + " was processed");
        }, pool);
    }

    public int getTotalProcessedOrders() {
        return totalProcessedOrders.get();
    }
}
