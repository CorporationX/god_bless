package school.faang.godbless.bjs2_38286;

import java.util.List;

public class AmazonOrderProcessing {
    public static void main(String[] args) {
        OrderProcessor processor = new OrderProcessor();
        List<Order> orders = List.of(
                new Order(1, Order.Status.NEW),
                new Order(2, Order.Status.NEW),
                new Order(3, Order.Status.NEW),
                new Order(4, Order.Status.PROCESSED),
                new Order(5, Order.Status.ERROR),
                new Order(6, Order.Status.NEW),
                new Order(7, Order.Status.NEW),
                new Order(8, Order.Status.NEW),
                new Order(9, Order.Status.NEW),
                new Order(10, Order.Status.NEW),
                new Order(11, Order.Status.NEW)
        );
        processor.processAllOrders(orders);
    }
}
