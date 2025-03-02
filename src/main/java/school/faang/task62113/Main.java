package school.faang.task62113;

import school.faang.task62113.service.Order;
import school.faang.task62113.service.OrderProcessor;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        OrderProcessor processor = new OrderProcessor();
        List<Order> orders = List.of(
                new Order(1, "Новый"),
                new Order(2, "Новый"),
                new Order(3,"Новый")
                );
        processor.processAllOrders(orders);
    }
}
