package faang.school.godbless.BJS2_24691;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class OrderProcessor {

    private final AtomicInteger totalProcessedOrders = new AtomicInteger(0);

    public CompletableFuture<Order> processOrder(Order order) {

        return CompletableFuture.supplyAsync(() -> {
            System.out.println("Processing order: " + order.getId());
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                log.error(e.getMessage());
                throw new RuntimeException(e);
            }

            order.setStatus(Status.DONE);

            totalProcessedOrders.incrementAndGet();

            System.out.println("Processed order: " + order.getId());
            return order;
        });
    }

    public int getTotalProcessedOrders() {
        return totalProcessedOrders.get();
    }
}
