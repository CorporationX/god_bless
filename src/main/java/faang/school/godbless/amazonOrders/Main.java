package faang.school.godbless.amazonOrders;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Main {
    public static void main(String[] args) {
        OrderProcessor orderProcessor = new OrderProcessor();

        List<Order> orders = List.of(
                new Order(1, "To be processed"),
                new Order(2, "To be processed"),
                new Order(3, "To be processed"),
                new Order(4, "To be processed"),
                new Order(5, "To be processed"),
                new Order(6, "To be processed")
        );

        List<CompletableFuture<Void>> futures = orders.stream()
                .map(orderProcessor::processOrder)
                .toList();

        CompletableFuture<Void> allOf = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));

        try {
            allOf.get();
            int totalOrdersProcessed = orderProcessor.getTotalProcessedOrders().get();
            System.out.println("Total orders processed: " + totalOrdersProcessed);
        } catch (InterruptedException | ExecutionException e) {
            System.out.println("Processing orders failed");
        }
    }
}
