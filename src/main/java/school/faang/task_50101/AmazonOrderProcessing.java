package school.faang.task_50101;

import java.util.List;

public class AmazonOrderProcessing {
    public static void main(String[] args) {
        OrderProcessor processor = new OrderProcessor();

        List<Order> orders = List.of(
                new Order(1, OrderStatus.NEW),
                new Order(2, OrderStatus.NEW),
                new Order(3, OrderStatus.CANCELED),
                new Order(4, OrderStatus.NEW)
        );

        processor.processAllOrders(orders);
    }
}