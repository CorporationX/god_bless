package faang.school.godbless.bjs2_5940;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {

    public static void main(String[] args) {
        OrderProcessor orderProcessor = new OrderProcessor();

        List<Order> orders = List.of(new Order(1), new Order(2), new Order(3), new Order(4), new Order(5));

        List<CompletableFuture<Void>> futures = orders.stream()
                .map(orderProcessor::processOrder)
                .toList();

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();

        System.out.println("Total processed orders: " + orderProcessor.getTotalProcessedOrders());
    }
}
