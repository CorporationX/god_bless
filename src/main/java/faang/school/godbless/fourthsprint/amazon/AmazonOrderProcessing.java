package faang.school.godbless.fourthsprint.amazon;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.IntStream;

public class AmazonOrderProcessing {
    public static final int NUM_ORDERS = 100;

    public static void main(String[] args) {
        OrderProcessor orderProcessor = new OrderProcessor();
        List<Order> orders = getOrders();

        List<CompletableFuture<Void>> futures = orders.stream()
                .map(orderProcessor::processOrder).toList();

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();

        System.out.println("\nTotal processed orders: " + orderProcessor.getTotalProcessedOrders());
    }

    public static List<Order> getOrders() {
        return IntStream.rangeClosed(1, NUM_ORDERS)
                .mapToObj(Order::new)
                .toList();
    }
}
