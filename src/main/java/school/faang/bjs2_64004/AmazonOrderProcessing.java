package school.faang.bjs2_64004;

import java.util.List;

public class AmazonOrderProcessing {
    public static void main(String[] args) {
        OrderProcessor processor = new OrderProcessor();

        List<Order> orders = List.of(
                new Order(1, Status.NEW),
                new Order(2, Status.NEW),
                new Order(3, Status.NEW)
        );

        processor.processOrder(orders);
    }
}
