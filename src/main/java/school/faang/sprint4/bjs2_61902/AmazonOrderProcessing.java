package school.faang.sprint4.bjs2_61902;

import java.util.List;

public class AmazonOrderProcessing {
    public static void main(String[] args) {
        OrderProcessor processor = new OrderProcessor();

        List<Order> orders = List.of(
                new Order(1, OrderStatus.NEW),
                new Order(2, OrderStatus.NEW),
                new Order(3, OrderStatus.NEW)
        );

        processor.processAllOrders(orders);
        orders.forEach(order -> System.out.println("Заказ #" + order.getId() + ": " + order.getStatus()));
    }
}
