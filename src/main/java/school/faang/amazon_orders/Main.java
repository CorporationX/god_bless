package school.faang.amazon_orders;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        OrderProcessor processor = new OrderProcessor();

        List<Order> orders = List.of(
                new Order(1, OrderStatus.NEW),
                new Order(2, OrderStatus.NEW),
                new Order(3, OrderStatus.NEW)
        );

        List<CompletableFuture<Void>> futures = orders.stream()
                .map(processor::processOrder)
                .toList();

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]))
                .join();

        orders.forEach(order -> System.out.println(order.getStatus()));
        System.out.println(processor.getTotalProcessedOrders().get());
    }
}
