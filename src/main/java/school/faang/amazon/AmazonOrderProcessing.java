package school.faang.amazon;

import java.util.ArrayList;
import java.util.List;

public class AmazonOrderProcessing {
    public static void main(String[] args) {
        try {
            OrderProcessor orderProcessor = new OrderProcessor();

            List<Order> orders = new ArrayList<>(List.of(new Order(1, OrderStatus.NEW),
                    new Order(2, OrderStatus.PROCESSED),
                    new Order(3, OrderStatus.CANCELED)));

            orderProcessor.processAllOrders(orders);
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }
}
