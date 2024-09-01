package faang.school.godbless.collecting_orders_on_amazon;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {

    public static void main(String[] args) {
        List<Order> orders = List.of(new Order(1),
                new Order(2),
                new Order(3),
                new Order(4),
                new Order(5));

        OrderProcessor orderProcessor = new OrderProcessor();

        List<CompletableFuture<Void>> futures = orders.stream()
                .map(orderProcessor::processOrder)
                .toList();

        CompletableFuture<Void> futureResult = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]))
                .thenRun(() -> System.out.println("Результат = " + orderProcessor.getTotalProcessedOrders()));

        futureResult.join();
    }
}
