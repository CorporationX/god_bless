package school.faang.amazonorders;

import java.util.List;

public class AmazonOrderProcessing {

    public static void main(String[] args) {
        OrderProcessor processor = new OrderProcessor();

        List<Order> orders = List.of(
                new Order(1, Status.NEW.getName()),
                new Order(2, Status.NEW.getName()),
                new Order(3, Status.NEW.getName())
        );

        processor.processAllOrders(orders);
    }
}
