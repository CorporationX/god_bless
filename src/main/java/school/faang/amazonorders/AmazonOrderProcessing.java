package school.faang.amazonorders;

import java.util.ArrayList;
import java.util.List;

public class AmazonOrderProcessing {
    private static final OrderProcessor PROCESSOR = new OrderProcessor();
    private static final List<Order> ORDERS = new ArrayList<>();
    private static final int TOTAL_ORDERS = 50;

    public static void main(String[] args) {
        for (int i = 0; i < TOTAL_ORDERS; i++) {
            createOrder();
        }
        PROCESSOR.processAllOrders(ORDERS);
    }

    private static void createOrder() {
        ORDERS.add(new Order());
    }
}
