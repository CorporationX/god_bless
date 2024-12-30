package school.faang.task_50142;

import java.util.List;

public class AmazonOrderProcessing {
    public static void main(String[] args) {
        OrderProcessor processor = new OrderProcessor();

        List<Order> orders = List.of(
                new Order(1, StatusOrder.NEW),
                new Order(2, StatusOrder.NEW),
                new Order(3, StatusOrder.NEW)
        );

        orders.forEach(processor::processOrder);

        processor.totalOrders();
    }
}
