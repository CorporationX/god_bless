package school.faang.task_50072;

import java.util.List;

public class AmazonOrderProcessing {
    private static final String NEW_STATUS = Status.NEW.getTitle();

    public static void main(String[] args) {
        OrderProcessor processor = new OrderProcessor();
        List<Order> orders = List.of(
                new Order(NEW_STATUS),
                new Order(NEW_STATUS),
                new Order(NEW_STATUS)
        );
        processor.processAllOrders(orders);
    }
}

