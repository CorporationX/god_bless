package school.faang.task_61993;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Order> orders = List.of(
                new Order(1, Status.NEW),
                new Order(2, Status.NEW),
                new Order(3, Status.NEW)
        );

        OrderProcessor processor = new OrderProcessor();
        processor.processAllOrders(orders);
    }
}
