package school.faang.m1.future.amazone;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class OrderProcessor implements AutoCloseable {

    ExecutorService exec = Executors.newFixedThreadPool(
            Math.min(4, Math.max(1, Runtime.getRuntime().availableProcessors()))
    );

    private final AtomicInteger totalProcessedOrders = new AtomicInteger(0);

    public CompletableFuture<Order> processOrder(Order order) {

        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            order.setStatus(Order.Status.PROCESSED);
            totalProcessedOrders.getAndAdd(1);
            return order;
        }, exec);
    }

    public void processAllOrders(List<Order> orders) {
        CompletableFuture<?>[] futures = orders.stream().map(this::processOrder)
                .toArray(CompletableFuture[]::new);

        CompletableFuture.allOf(futures).join();

        System.out.println("Processed orders: " + totalProcessedOrders.get());
    }

    @Override
    public void close() {
        exec.shutdown();
    }
}

