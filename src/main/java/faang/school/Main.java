package faang.school;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<Order> orders = Stream.iterate(1, i -> i + 1).limit(15)
                .map(i -> new Order(i, Integer.toString(i)))
                .toList();
        OrderProcessor processor = new OrderProcessor();

        var futures = orders.stream().map(processor::processOrder).toList();
        CompletableFuture.allOf(futures.toArray(CompletableFuture[]::new))
                .thenRun(() -> System.out.println(processor.getTotalProcessedOrders())).join();
        System.out.println("Done");
    }
}
