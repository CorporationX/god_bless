package faang.school.godbless.multithreading.collect_orders;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        OrderProcessor processor = new OrderProcessor();

        List<Order> orders = IntStream.rangeClosed(1, 10)
                .mapToObj(i -> new Order(i, Status.NEW))
                .toList();

        List<CompletableFuture<Void>> orderFutures = orders.stream()
                .map(processor::processOrder)
                .toList();

        CompletableFuture.allOf(orderFutures.toArray(new CompletableFuture[0]))
                .thenRun(() -> {
                    orders.forEach(order -> System.out.println(order.toString()));
                    System.out.println(processor.getTotalProcessedOrders().get() + " orders have been processed");
                })
                .join();
    }
}
