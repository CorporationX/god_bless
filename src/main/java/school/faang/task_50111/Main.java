package school.faang.task_50111;

import java.util.List;

import static school.faang.task_50111.OrderStatus.New;

public class Main {
    public static void main(String[] args) {

        OrderProcessor processor = new OrderProcessor();

        List<Order> orders = List.of(
                new Order(1, New),
                new Order(2, New),
                new Order(3, New)
        );

        processor.processAllOrders(orders);
    }
}