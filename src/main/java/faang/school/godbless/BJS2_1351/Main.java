package faang.school.godbless.BJS2_1351;

import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        OrderProcessor orderProcessor = new OrderProcessor();

        Order order1 = new Order();
        Order order2 = new Order();
        Order order3 = new Order();

        CompletableFuture<Void> processOrder1 = orderProcessor.processOrder(order1);
        CompletableFuture<Void> processOrder2 = orderProcessor.processOrder(order2);
        CompletableFuture<Void> processOrder3 = orderProcessor.processOrder(order3);

        CompletableFuture<Void> completableFutures = CompletableFuture.allOf(processOrder1, processOrder2, processOrder3);
        completableFutures.thenRun(()
                        -> System.out.println("All orders processed. Total count: " + orderProcessor.getTotalProcessedOrders()))
                .join();
    }
}