package faang.school.godbless.Sprint4Future.Amazon;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class OrderProcessor {
    private AtomicInteger totalProcessedOrders = new AtomicInteger(0);

    public static void main(String[] args) {
        OrderProcessor orderProcessor = new OrderProcessor();
        Order groceries = new Order("New");
        Order electronics = new Order("New");
        Order furniture = new Order("New");
        Order hardware = new Order("New");

        CompletableFuture<Void> allCompletableFutures = CompletableFuture.allOf(orderProcessor.processOrder(groceries)
                , orderProcessor.processOrder(electronics)
                , orderProcessor.processOrder(furniture)
                , orderProcessor.processOrder(hardware));

        allCompletableFutures.thenAccept((v) -> System.out.println("Total orders:" + orderProcessor.totalProcessedOrders));
        allCompletableFutures.join();
    }

    public CompletableFuture<Order> processOrder(Order order) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println("Order processed...");
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            order.setStatus("Processed");
            totalProcessedOrders.incrementAndGet();
            return order;
        });
    }
}
