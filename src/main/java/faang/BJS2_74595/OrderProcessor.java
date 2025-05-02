package faang.BJS2_74595;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import static faang.BJS2_74595.OrderStatus.*;

public class OrderProcessor {
    private static final long PROCESSED_ORDERS_TIME_IN_SECONDS = 2;
    private final AtomicInteger totalProcessedOrders = new AtomicInteger();

    public CompletableFuture<Order> processOrder(Order order) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(PROCESSED_ORDERS_TIME_IN_SECONDS);
                order.setStatus(PROCESSED);
                totalProcessedOrders.incrementAndGet();
                return order;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }

    public int getTotalProcessedOrders() {
        return totalProcessedOrders.get();
    }
}
