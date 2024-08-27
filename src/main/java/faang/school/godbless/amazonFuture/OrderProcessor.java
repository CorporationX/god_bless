package faang.school.godbless.amazonFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

public class OrderProcessor {
    private final AtomicInteger totalProcessedOrders = new AtomicInteger(0);

    private final int PROCESSED_STATUS = 1;

    public CompletableFuture<Void> processOrder(Order order) {
        return CompletableFuture.runAsync(() -> {
                    try {
                        Thread.sleep(ThreadLocalRandom.current().nextLong(100L, 300L));
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                    order.setStatus(PROCESSED_STATUS);
                })
                .thenRun(() -> totalProcessedOrders.addAndGet(1));
    }

    public void printProcessedOrders() {
        System.out.println(totalProcessedOrders);
    }
}
