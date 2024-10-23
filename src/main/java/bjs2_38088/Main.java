package bjs2_38088;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        List<Order> orders = List.of(
                new Order(),
                new Order(),
                new Order(),
                new Order(),
                new Order()
        );
        OrderProcessor processor = new OrderProcessor();

        CompletableFuture[] futures = orders.stream()
                .map(processor::processOrder)
                .toArray(CompletableFuture[]::new);

        CompletableFuture.allOf(futures).join();
        System.out.println("Total processed orders: " + processor.getTotalProcessedOrders());
    }
}
