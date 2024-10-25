package school.faang.amazon;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class AmazonOrderProcessing {
    public static void main(String[] args) {
        OrderProcessor processor = new OrderProcessor();

        List<Order> orders = List.of(
                new Order(1, "NEW"),
                new Order(2, "NEW"),
                new Order(3, "NEW")
        );

        System.out.println("Initial state of orders:");
        System.out.println("Total Processed Orders: " + processor.getTotalProcessedOrders().intValue());
        orders.forEach(order -> System.out.println("Order ID: " + order.getId() + " New Status: " + order.getStatus()));

        System.out.println("\nOrders after processing:");
        processor.processAllOrders(orders).forEach(CompletableFuture::join);
        System.out.println("Total Processed Orders: " + processor.getTotalProcessedOrders().intValue());
        orders.forEach(order -> System.out.println("Order ID: " + order.getId() + " New Status: " + order.getStatus()));
    }
}