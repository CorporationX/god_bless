package school.faang.task_50179;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

public class OrderProcessor {
    private static final int SLEEP_CONSTANT = 1000;
    private static final AtomicInteger totalProcessedOrders = new AtomicInteger(0);

    public static AtomicInteger getTotalProcessedOrders() {
        int newTotalProcessedOrders = totalProcessedOrders.get();
        return new AtomicInteger(newTotalProcessedOrders);
    }

    public CompletableFuture<Void> processOrder(Order order) {
        return CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(SLEEP_CONSTANT);
                order.setStatus(Status.PROCESSED);
                totalProcessedOrders.addAndGet(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
                throw new RuntimeException();
            }
        });
    }
}
