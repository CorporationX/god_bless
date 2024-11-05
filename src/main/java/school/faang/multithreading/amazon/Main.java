package school.faang.multithreading.amazon;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        OrderProcessor processor = new OrderProcessor();

        List<Order> orders = List.of(
                new Order(1, OrderStatus.NEW),
                new Order(2, OrderStatus.NEW),
                new Order(3, OrderStatus.NEW),
                new Order(4, OrderStatus.NEW),
                new Order(5, OrderStatus.NEW),
                new Order(6, OrderStatus.NEW)
        );

        processor.processAllOrders(orders);
    }
}
