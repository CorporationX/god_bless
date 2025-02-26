package school.faang.amazonorders;

import java.util.ArrayList;
import java.util.List;

public class AmazonOrderProcessing {
    private static final OrderProcessor PROCESSOR = new OrderProcessor();
    private static final List<Order> ORDERS = new ArrayList<>();

    public static void main(String[] args) {
        for (int i = 0; i < 50; i++) {
            createOrder();
        }
        PROCESSOR.processAllOrders(ORDERS);
    }

    private static void createOrder() {
        ORDERS.add(new Order());
    }
}
