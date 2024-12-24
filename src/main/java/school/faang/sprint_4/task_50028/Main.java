package school.faang.sprint_4.task_50028;

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

        List<CompletableFuture<Void>> completableFutures = processor.processAllOrders(orders);

        CompletableFuture.allOf(completableFutures.toArray(new CompletableFuture[0])).join();
        System.out.println(processor.getTotalProcessedOrders());
        System.out.println(orders);
    }
}
