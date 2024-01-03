package faang.school.godbless.multithreading_async.collecting_orders_on_amazon;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        OrderProcessor orderProcessor = new OrderProcessor();
        List<CompletableFuture<Order>> futures = new ArrayList<>();
        System.out.println("Start");
        long start = System.currentTimeMillis();
        Stream.of(
                new Order(1, 0),
                new Order(2, 0),
                new Order(3, 0),
                new Order(4, 0),
                new Order(5, 0),
                new Order(6, 0),
                new Order(7, 0),
                new Order(8, 0),
                new Order(9, 0),
                new Order(10, 0)
        ).forEach(order -> futures.add(orderProcessor.processOrder(order)));

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();

        orderProcessor.shutdown();

        long end = System.currentTimeMillis();

        System.out.println((end - start) + " - " + orderProcessor.getTotalProcessedOrders());
    }
}
