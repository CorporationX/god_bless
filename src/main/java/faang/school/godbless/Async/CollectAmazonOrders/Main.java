package faang.school.godbless.Async.CollectAmazonOrders;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Main {
    public static void main(String[] args) {
        OrderProcessor orderProcessor = new OrderProcessor();

        Order order1 = new Order(1, "Pending");
        Order order2 = new Order(2, "Pending");
        Order order3 = new Order(3, "Pending");
        Order order4 = new Order(3, "Pending");

        CompletableFuture<Void> future1 = orderProcessor.processOrder(order1);
        CompletableFuture<Void> future2 = orderProcessor.processOrder(order2);
        CompletableFuture<Void> future3 = orderProcessor.processOrder(order3);
        CompletableFuture<Void> future4 = orderProcessor.processOrder(order4);

        CompletableFuture<Void> allFutures = CompletableFuture.allOf(future1, future2, future3, future4);
        try {
            allFutures.get();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Total processed orders: " + orderProcessor.getTotalProcessedOrders());
    }
}
