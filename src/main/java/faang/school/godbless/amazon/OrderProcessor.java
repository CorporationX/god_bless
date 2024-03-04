package faang.school.godbless.amazon;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

public class OrderProcessor {
    private static AtomicInteger totalProcessedOrders = new AtomicInteger(0);

    public static CompletableFuture<Void> processOrder(Order order) {
        return CompletableFuture.runAsync(() -> {
            System.out.println("Order with id " + order.getId() + " is processing");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            order.setStatus(Status.PROCESSED);
            totalProcessedOrders.addAndGet(1);
        });
    }

    public static AtomicInteger getTotalProcessedOrders() {
        return totalProcessedOrders;
    }
}
