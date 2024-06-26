package faang.school.godbless.collectingOrdersOnAmazon;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

public class OrderProcessor {
    private AtomicInteger totalProcessedOrders = new AtomicInteger(0);

    public void processOrder(Order order) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        CompletableFuture.runAsync(() -> {
            if (order.getStatus() == Status.progress) {
                order.setStatus(Status.processed);
                totalProcessedOrders.incrementAndGet();
            }
        });
    }

    public int getTotalProcessedOrders() {
        return totalProcessedOrders.get();
    }
}
