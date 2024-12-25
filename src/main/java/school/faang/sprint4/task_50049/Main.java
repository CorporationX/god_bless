package school.faang.sprint4.task_50049;

import java.util.List;

import static school.faang.sprint4.task_50049.OrderStatus.NEW;

public class Main {
    public static void main(String[] args) {
        OrderProcessor processor = new OrderProcessor();

        List<Order> orders = List.of(
                new Order(1, NEW),
                new Order(2, NEW),
                new Order(3, NEW)
        );

        processor.processAllOrders(orders);
    }
}
