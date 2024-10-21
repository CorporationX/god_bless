package school.faang.collect_orders_from_amazon.main;

import school.faang.collect_orders_from_amazon.main_code.Order;
import school.faang.collect_orders_from_amazon.main_code.OrderProcessor;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        OrderProcessor processor = new OrderProcessor();

        List<Order> orders = List.of(
                new Order(1, "Новый"),
                new Order(2, "Новый"),
                new Order(3, "Новый")
        );

        processor.processAllOrders(orders);
    }
}
