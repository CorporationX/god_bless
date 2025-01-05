package school.faang.sprint_4.task_50217;

import java.util.List;
import java.util.concurrent.ExecutionException;

public class AmazonOrderProcessing {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<Order> orders = List.of(
                new Order(1),
                new Order(2),
                new Order(3),
                new Order(4),
                new Order(5)
        );

        OrderProcessor processor = new OrderProcessor();
        processor.processAllOrders(orders);
    }
}
