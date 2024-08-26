package faang.school.godbless.fourthsprint.amazon;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class OrderProcessor {
    private static final int MAX_WAIT_TIME = 5;

    private final AtomicInteger totalProcessedOrders = new AtomicInteger(0);

    public CompletableFuture<Void> processOrder(Order order) {
        return CompletableFuture.runAsync(() -> {
            System.out.println("Order " + order.getId() + " status is: " + order.getStatus());
            try {
                TimeUnit.SECONDS.sleep(ThreadLocalRandom.current().nextInt(1, MAX_WAIT_TIME));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }

            order.setStatus("Processed");
            totalProcessedOrders.incrementAndGet();
            System.out.println("Order " + order.getId() + " status has been changed to: " + order.getStatus());
        });
    }

    public int getTotalProcessedOrders() {
        return totalProcessedOrders.get();
    }
}
