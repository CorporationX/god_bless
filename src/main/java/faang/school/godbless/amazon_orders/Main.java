package faang.school.godbless.amazon_orders;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        List<Order> orders = List.of(
                new Order(1, Status.CREATED),
                new Order(2, Status.CREATED),
                new Order(3, Status.CREATED),
                new Order(4, Status.CREATED),
                new Order(5, Status.CREATED)
        );

        OrderProcessor orderProcessor = new OrderProcessor();
        List<CompletableFuture<Void>> futures = new ArrayList<>();

        for (Order order : orders){
            futures.add(orderProcessor.processOrder(order));
        }

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();

        orders.stream().forEach(System.out::println);
    }
}
