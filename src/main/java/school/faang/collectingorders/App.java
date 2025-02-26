package school.faang.collectingorders;

import java.util.List;

public class App {
    private static final List<Order> ORDERS = List.of(
            new Order(1, OrderStatus.NEW),
            new Order(2, OrderStatus.NEW),
            new Order(3, OrderStatus.NEW)
    );

    public static void main(String[] args) {
        OrderProcessor processor = new OrderProcessor();
        processor.processAllOrders(ORDERS);
    }
}
