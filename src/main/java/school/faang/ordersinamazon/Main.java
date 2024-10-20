package school.faang.ordersinamazon;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final int COUNT_ORDER = 100;
    public static void main(String[] args) {
        OrderProcessor processor = new OrderProcessor();

        List<Order> orders = new ArrayList<>();
        for (int i = 0; i < COUNT_ORDER; i++) {
            orders.add(new Order(i, OrderStatus.NEW));
        }

        processor.processAllOrders(orders);
    }
}
