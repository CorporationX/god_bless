package school.faang.collectamazon;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class Main {
    public static void main(String[] args) {
        OrderProcessor processor = new OrderProcessor();

        List<Order> orders = List.of(
                new Order(1, OrderStatus.NEW),
                new Order(2, OrderStatus.NEW),
                new Order(3, OrderStatus.NEW)
        );

        processor.processAllOrders(orders);
    }
}

