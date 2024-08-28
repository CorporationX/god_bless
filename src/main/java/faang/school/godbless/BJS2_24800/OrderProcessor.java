package faang.school.godbless.BJS2_24800;

import lombok.AllArgsConstructor;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicInteger;

@AllArgsConstructor
public class OrderProcessor {
    private static AtomicInteger totalProcessedOrders = new AtomicInteger(0);
    private ExecutorService executor;

    public CompletableFuture<Order> processOrder(Order order) {
        return CompletableFuture.supplyAsync(() -> {
            order.setStatus(Status.IN_PROCESSING);
            System.out.println("Processing order: " + order.getId());

            try {
                Thread.sleep(5000L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            totalProcessedOrders.incrementAndGet();
            order.setStatus(Status.DONE);
            System.out.println("Processed order: " + order.getId());

            return order;
        }, executor);
    }

    public void stop() {
        executor.shutdownNow();
    }

    public static int get() {
        return totalProcessedOrders.get();
    }
}
