package faang.school.godbless.collect_orders_amazon;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        List<Order> orders = List.of(
                new Order(1, Status.IN_PROGRESS),
                new Order(2, Status.IN_PROGRESS),
                new Order(3, Status.IN_PROGRESS),
                new Order(4, Status.IN_PROGRESS),
                new Order(5, Status.IN_PROGRESS),
                new Order(6, Status.IN_PROGRESS),
                new Order(7, Status.IN_PROGRESS),
                new Order(8, Status.IN_PROGRESS),
                new Order(9, Status.IN_PROGRESS),
                new Order(10, Status.IN_PROGRESS)
        );

        OrderProcessor orderProcessor = new OrderProcessor();

        List<CompletableFuture<Void>> futures = orders.stream().map(orderProcessor::processOrder).toList();
        futures.forEach(CompletableFuture::join);

        System.out.println("Total orders: " + orderProcessor.getAllProcessedOrders());
    }
}
