package school.faang.collectingordersamazon;

import java.util.List;

public class AmazonOrderProcessing {
    public static void main(String[] args) {
        OrderProcessor processor = new OrderProcessor();

        List<Order> orders = List.of(
                new Order(1, "New"),
                new Order(2, "New"),
                new Order(3, "New")
        );

        processor.processAllOrders(orders);
    }
}
