package school.faang.amazon_bjs2_93203;

import java.util.List;

public class AmazonOrderProcessing {
    public static void main(String[] args) {
        OrderProcessor processor = new OrderProcessor();

        List<Order> orders = List.of(
                new Order(1, Status.New),
                new Order(2, Status.New),
                new Order(3, Status.New)
        );

        processor.processAllOrders(orders);
    }
}
