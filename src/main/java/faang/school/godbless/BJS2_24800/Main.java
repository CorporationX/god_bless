package faang.school.godbless.BJS2_24800;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        List<Order> orders = getOrders();
        ExecutorService executor = Executors.newFixedThreadPool(orders.size());
        OrderProcessor orderProcessor = new OrderProcessor(executor);

        var completedOrders = orders.stream()
                .map(orderProcessor::processOrder)
                .toList();
        CompletableFuture.allOf(completedOrders.toArray(new CompletableFuture[0])).join();
        orderProcessor.stop();

        System.out.println("Количество выполненных заказов: " + OrderProcessor.get());
    }

    private static List<Order> getOrders() {
        return List.of(
                new Order(1),
                new Order(2),
                new Order(3),
                new Order(4),
                new Order(5),
                new Order(6),
                new Order(7),
                new Order(8),
                new Order(9),
                new Order(10)
        );
    }
}
