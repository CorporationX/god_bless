package amazonorders;

import java.util.List;
import java.util.stream.IntStream;

public class AmazonOrderProcessing {
    public static void main(String[] args) {
        OrderProcessor processor = new OrderProcessor();

        List<Order> orders = IntStream.rangeClosed(1, 100)
                .mapToObj(Order::new)
                .toList();

        processor.processAllOrders(orders);
    }
}
