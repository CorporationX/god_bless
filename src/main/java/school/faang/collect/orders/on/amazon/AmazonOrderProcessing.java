package school.faang.collect.orders.on.amazon;

import java.util.List;

public class AmazonOrderProcessing {
    public static void main(String[] args) {
        OrderProcessor processor = new OrderProcessor();

        List<Order> orders = List.of(
                new Order(1, OrderStatus.NEW),
                new Order(2, OrderStatus.NEW),
                new Order(3, OrderStatus.NEW)
        );

        try {
            processor.processAllOrders(orders);
            System.out.println("All orders processed successfully!");
        } catch (Exception e) {
            System.err.println("Error processing orders: " + e.getMessage());
        }
    }
}
