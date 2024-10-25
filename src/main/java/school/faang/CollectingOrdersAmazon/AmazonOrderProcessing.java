package school.faang.CollectingOrdersAmazon;

import java.util.List;

public class AmazonOrderProcessing {
    public static void main(String[] args) {
        OrderProcessor processor = new OrderProcessor();

        List<Order> orders = List.of(
                new Order(1, OrderStatus.PENDING),
                new Order(2, OrderStatus.PENDING),
                new Order(3, OrderStatus.PENDING)
        );

        processor.processAllOrders(orders);
        processor.shutdown();
    }
}
