package school.faang.packing_orders_in_amazon;

import java.util.List;

public class OrderProcessing {
    public static void main(String[] args) {
        OrderProcessor processor = new OrderProcessor();

        List<Order> orders = List.of(
                new Order(OrderStatus.NEW),
                new Order(OrderStatus.NEW),
                new Order(OrderStatus.PROCESSED),
                new Order(OrderStatus.PROCESSED),
                new Order(OrderStatus.NEW)
        );

        processor.processAllOrders(orders);
    }
}
