package faang.school.godbless.amazonorders;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {

    public static void main(String[] args) {
        List<Order> orders = getOrders();
        OrderProcessor orderProcessor = new OrderProcessor();
        List<CompletableFuture<Order>> processedOrders = new ArrayList<>();

        orders.forEach(order -> processedOrders.add(orderProcessor.processOrderAsync(order)));
        CompletableFuture.allOf(processedOrders.toArray(CompletableFuture[]::new)).join();

        orderProcessor.shutdownAndAwaitTermination();
        System.out.println(orderProcessor.getTotalProcessedOrders());
    }

    private static List<Order> getOrders() {
        return List.of(new Order(1),
                new Order(2),
                new Order(3),
                new Order(4));
    }
}
