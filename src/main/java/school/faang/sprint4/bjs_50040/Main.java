package school.faang.sprint4.bjs_50040;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class Main {
    public static void main(String[] args) {
        List<Order> orders = List.of(
                new Order(1, OrderStatus.NEW),
                new Order(2, OrderStatus.NEW),
                new Order(3, OrderStatus.NEW)
        );

        OrderProcessor processor = new OrderProcessor();
        processor.processAllOrders(orders);
        log.info("Orders new status:");
        orders.forEach(order -> log.info("{}", order));

    }
}
