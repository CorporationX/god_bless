package school.faang.amazon2;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class AmazonOrderProcessing {
    public static void main(String[] args) {
        OrderProcessor processor = new OrderProcessor();

        List<Order> orders = List.of(
                new Order(1, "Новый"),
                new Order(2, "Новый"),
                new Order(3, "Новый")
        );

        List<CompletableFuture<Void>> futures = orders.stream()
                .map(processor::processOrder)
                .toList();

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();

        System.out.println("Total processed orders: " + processor.getTotalProcessedOrders());

        orders.forEach(o -> System.out.println("Order " + o.getId() + " статус: " + o.getStatus()));
    }
}