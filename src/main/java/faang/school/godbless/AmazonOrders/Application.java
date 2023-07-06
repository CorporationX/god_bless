package faang.school.godbless.AmazonOrders;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Application {
    public static void main(String[] args) {
        OrderProcessor orderProcessor = new OrderProcessor();
        List<Order> orders = List.of(
                new Order(1, "В обработке"),
                new Order(2, "В обработке"),
                new Order(3, "В обработке"),
                new Order(4, "В обработке"),
                new Order(5, "В обработке"),
                new Order(6, "В обработке"),
                new Order(7, "В обработке"),
                new Order(8, "В обработке"),
                new Order(9, "В обработке"),
                new Order(10, "В обработке")
        );
        List<CompletableFuture> futures = new ArrayList<>();

        for (Order order : orders) {
            futures.add(orderProcessor.processOrder(order));
        }

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[futures.size()])).join();

        System.out.println(orderProcessor.getTotalProcessedOrders().get());

        System.out.println(orders);
    }
}
