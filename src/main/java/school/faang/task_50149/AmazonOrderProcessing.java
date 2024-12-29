package school.faang.task_50149;

import java.util.ArrayList;
import java.util.List;

public class AmazonOrderProcessing {

    public static void main(String[] args) {
        OrderProcessor processor = new OrderProcessor();

        List<Order> orders = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            orders.add(new Order(i));
        }

        processor.processAllOrders(orders);
    }
}
