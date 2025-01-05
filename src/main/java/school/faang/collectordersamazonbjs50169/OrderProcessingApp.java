package school.faang.collectordersamazonbjs50169;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class OrderProcessingApp {
    public static void main(String[] args) {
        OrderProcessor orderProcessor = new OrderProcessor();

        List<Order> orders = IntStream.rangeClosed(1, 5)
                .mapToObj(id -> new Order(id, OrderStatus.NEW))
                .collect(Collectors.toList());

        List<CompletableFuture> futures = orders.stream()
                .map(orderProcessor::processOrder)
                .collect(Collectors.toList());

        CompletableFuture<Void> allOf = CompletableFuture.allOf(futures.toArray(new
                CompletableFuture[0]));
        allOf.join();

        System.out.println("Total number of orders processed: "
                + orderProcessor.getTotalProcessedOrders());
    }
}
