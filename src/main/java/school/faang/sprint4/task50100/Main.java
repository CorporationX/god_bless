package school.faang.sprint4.task50100;

import lombok.extern.slf4j.Slf4j;
import school.faang.sprint4.task50100.model.Order;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class Main {
    private static final int ORDERS_QUANTITY = 5;

    public static void main(String[] args) {
        List<Order> orders = new ArrayList<>();
        for (int i = 0; i < ORDERS_QUANTITY; i++) {
            orders.add(new Order(i));
        }

        OrderProcessor processor = new OrderProcessor();
        processor.processAllOrders(orders);
        log.info("Total processed orders: {} of {}", processor.getTotalProcessedOrders(), ORDERS_QUANTITY);
    }
}
