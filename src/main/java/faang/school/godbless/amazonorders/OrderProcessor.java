package faang.school.godbless.amazonorders;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class OrderProcessor {

    private final ExecutorService EXECUTOR_SERVICE = Executors.newCachedThreadPool();
    private AtomicInteger totalProcessedOrders = new AtomicInteger(0);

    public AtomicInteger getTotalProcessedOrders() {
        return totalProcessedOrders;
    }

    public CompletableFuture<Order> processOrderAsync(Order order) {
        return CompletableFuture.supplyAsync(() -> processOrder(order), EXECUTOR_SERVICE);
    }

    public void shutdownAndAwaitTermination() {
        EXECUTOR_SERVICE.shutdown();
        awaitTermination(5L);
    }

    private Order processOrder(Order order) {
        sleep(5L);
        order.setProcessed(true);
        totalProcessedOrders.incrementAndGet();
        return order;
    }

    private void awaitTermination(Long minutes) {
        try {
            EXECUTOR_SERVICE.awaitTermination(minutes, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private void sleep(Long seconds) {
        try {
            Thread.sleep(seconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
