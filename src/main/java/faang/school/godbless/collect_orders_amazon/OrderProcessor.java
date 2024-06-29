package faang.school.godbless.collect_orders_amazon;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

public class OrderProcessor {
    private AtomicInteger totalProcessedOrders = new AtomicInteger(0);

    public CompletableFuture<Void> processOrder(Order order) {
        return CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(new Random().nextInt(2000));
                order.setStatus(Status.PROCESSED);
                totalProcessedOrders.incrementAndGet();
            } catch (InterruptedException e) {
                throw new RuntimeException(String.format("Order %d interrupted from %s", order.getId(), Thread.currentThread().getName()));
            }
        });
    }

    public int getAllProcessedOrders() {
        return totalProcessedOrders.get();
    }
}
