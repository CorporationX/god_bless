package school.faang.BJS2_61948;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        OrderProcessor processor = new OrderProcessor();
        List<Order> orders = new ArrayList<>();
        for (int i = 0; i < ConstAndMessages.NUM_ORDERS; i++) {
            orders.add(new Order());
        }
        processor.processAllOrders(orders);
        processor.shutdown();
    }
}
