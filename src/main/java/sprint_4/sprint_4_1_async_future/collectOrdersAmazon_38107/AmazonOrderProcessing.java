package sprint_4.sprint_4_1_async_future.collectOrdersAmazon_38107;

import java.util.List;

import static sprint_4.sprint_4_1_async_future.collectOrdersAmazon_38107.OrderStatus.*;

public class AmazonOrderProcessing {
    public static void main(String[] args) {
        OrderProcessor processor = new OrderProcessor();

        List<Order> orders = List.of(
                new Order(1, NEW),
                new Order(2, NEW),
                new Order(3, CANCELED)
        );

        processor.processAllOrders(orders);
    }
}
