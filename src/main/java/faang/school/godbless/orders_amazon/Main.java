package faang.school.godbless.orders_amazon;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        OrderProcessor processor = new OrderProcessor();

        List<Order> orders = List.of(
                new Order(1, "New"),
                new Order(2, "New"),
                new Order(3, "New")
        );

        ExecutorService poolThreads = Executors.newFixedThreadPool(orders.size());

        CompletableFuture<?>[] futures = orders.stream()
                .map(processor::processOrder)
                .toArray(CompletableFuture[]::new);

        CompletableFuture.allOf(futures).join();

        System.out.println("Total processed orders: " + processor.getTotalProcessedOrders().get());
    }
}
