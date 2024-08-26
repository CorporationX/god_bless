package faang.school.godbless.BJS2_24650;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        List<Order> orders =
                List.of(new Order(6), new Order(1), new Order(2), new Order(3), new Order(4), new Order(5));
        ExecutorService executorService = Executors.newFixedThreadPool(orders.size());
        OrderProcessor orderProcessor = new OrderProcessor(executorService);

        CompletableFuture<Void> futures = CompletableFuture
                .allOf(orders
                        .stream()
                        .map(orderProcessor::processOrder)
                        .toArray(CompletableFuture[]::new)
                );

        futures.join();
        orderProcessor.shutdown();
        System.out.println(orderProcessor.getTotalProcessedOrders());
    }
}
