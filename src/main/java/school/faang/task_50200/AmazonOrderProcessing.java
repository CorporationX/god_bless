package school.faang.task_50200;

import java.util.List;

public class AmazonOrderProcessing {
    public static void main(String[] args) {
        OrderProcessor processor = new OrderProcessor();

        List<Order> orders = List.of(
                new Order(1, "New"),
                new Order(2, "New"),
                new Order(3, "New")
        );
        int result = processor.processAllOrders(orders);

        System.out.println("Processed " + result + " orders");
        System.out.println("All orders that have been processed: " + orders);
    }
}
