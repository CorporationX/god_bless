package Multithreading.bc3333_Collecting_Orders_from_Amazon;

import lombok.Getter;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

@Getter
public class OrderProcessor {
    private final AtomicInteger totalProcessedOrders = new AtomicInteger(0);

    public CompletableFuture<Order> processOrder(Order order) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        CompletableFuture<Order> completableFuture = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            order.setStatus("Processed");
            totalProcessedOrders.addAndGet(1);
            return order;
        }, executorService);

        executorService.shutdown();
        return completableFuture;
    }
}
