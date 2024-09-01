package faang.school.godbless.BJS2_25005;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class Main {
    private static final int ORDERS_COUNT = 1000;

    public static void main(String[] args) {
        List<Order> orders = IntStream.range(0, ORDERS_COUNT)
                .mapToObj(index -> new Order(index, "Created"))
                .toList();

        OrderProcessor orderProcessor = new OrderProcessor();
        ExecutorService service = Executors.newFixedThreadPool(ORDERS_COUNT);

        List<CompletableFuture<Void>> results = orders
                .stream()
                .map(order -> orderProcessor.processOrder(order, service))
                .toList();

        CompletableFuture.allOf(results.toArray(new CompletableFuture[0])).join();
        service.shutdown();

        System.out.println("Total orders: " + orderProcessor.getTotalProcessedOrders());
    }
}
