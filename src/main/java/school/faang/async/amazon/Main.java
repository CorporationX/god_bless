package school.faang.async.amazon;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        OrderProcessor processor = new OrderProcessor();

        List<Order> orders = List.of(
                new Order(1, OrderStatus.NEW),
                new Order(2, OrderStatus.NEW),
                new Order(3, OrderStatus.CANCELED)
        );

        processor.processAllOrders(orders);
    }
}
