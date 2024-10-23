package school.faang.amazon;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        OrderProcessor processor = new OrderProcessor();

        List<Order> orders = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            orders.add(new Order());
        }

        processor.processAllOrders(orders);
    }
}
