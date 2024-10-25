package school.faang.amazonorderprocessor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class OrderProcessor {

    private static AtomicInteger totalProcessedOrders = new AtomicInteger(0);

    public CompletableFuture<Void> processOrder(Order order) {
        return CompletableFuture.runAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            order.setStatus("Обработано");

            totalProcessedOrders.incrementAndGet();

            System.out.println("Order " + order.getId() + " has been processed. " + Thread.currentThread().getName());
        });
    }

    public void processAllOrders(List<Order> orders){
        List<CompletableFuture<Void>> futures = orders.stream()
                .map(this::processOrder)
                .collect(Collectors.toList());

        CompletableFuture<Void> allOf = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));

        allOf.thenRun(() -> {
            System.out.println("Обработано закакзов: " + totalProcessedOrders.get());}).join();
    }
}
