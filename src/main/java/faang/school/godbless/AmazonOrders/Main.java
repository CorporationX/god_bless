package faang.school.godbless.AmazonOrders;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(5);
        OrderProcessor orderProcessor = new OrderProcessor();
        Order order1 = new Order(1);
        Order order2 = new Order(2);
        CompletableFuture<Order> futureOrder1 = orderProcessor.processOrder(order1, executor);
        CompletableFuture<Order> futureOrder2 = orderProcessor.processOrder(order2, executor);

        CompletableFuture.allOf(futureOrder1, futureOrder2).join();
        System.out.println(OrderProcessor.totalProcessedOrders);

        executor.shutdown();
        try {
            if(!executor.awaitTermination(1, TimeUnit.HOURS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
