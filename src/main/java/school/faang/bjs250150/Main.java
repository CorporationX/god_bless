package school.faang.bjs250150;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        OrderProcessor processor = new OrderProcessor();

        List<Order> orders = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            orders.add(new Order(i + 1, OrderStatus.NEW));
        }
        processor.processAllOrders(orders);
    }
}