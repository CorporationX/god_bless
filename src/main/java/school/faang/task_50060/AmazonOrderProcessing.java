package school.faang.task_50060;

import java.util.List;

import static school.faang.task_50060.Status.NEW;

public class AmazonOrderProcessing {
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