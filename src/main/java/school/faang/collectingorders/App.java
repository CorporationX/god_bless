package school.faang.collectingorders;

import java.util.List;

public class App {
    private static final List<Order> ORDERS = List.of(
            new Order(1, "Новый"),
            new Order(2, "Новый"),
            new Order(3, "Новый")
    );

    public static void main(String[] args) {
        OrderProcessor processor = new OrderProcessor();
        processor.proccessAllOrders(ORDERS);
    }
}
