package bjs2_93201;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        OrderProcessor processor = new OrderProcessor();
        List<Order> orders = new ArrayList<>();

        for (int i = 1; i <= 10; i++) {
            orders.add(new Order(i, OrderStatus.NEW));
        }

        processor.processAllOrders(orders);
    }
}
