package mod1sp4.bjs2_38262_amazonOrders;

import java.util.List;
import static mod1sp4.bjs2_38262_amazonOrders.Status.*;

public class AmazonOrderProcessing {
    public static void main(String[] args) {
        OrderProcessor processor = new OrderProcessor();
        List<Order> orders = List.of(
                new Order(1, NEW),
                new Order(2, NEW),
                new Order(3, NEW)
        );
        processor.processAllOrders(orders);
        OrderProcessor.shuttingDownExecutor();
    }
}
