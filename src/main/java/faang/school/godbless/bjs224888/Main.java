package faang.school.godbless.bjs224888;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        List<CompletableFuture<Void>> futures = new ArrayList<>();
        OrderProcessor orderProcessor = new OrderProcessor();
        for (int i = 0; i < 15; i++) {
            CompletableFuture<Void> processedOrderFuture = orderProcessor.processOrder(new Order(i));
            futures.add(processedOrderFuture);
        }

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();
        System.out.println("Processed orders: " + orderProcessor.getTotalProcessedOrders());
    }
}