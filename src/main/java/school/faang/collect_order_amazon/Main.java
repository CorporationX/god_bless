package school.faang.collect_order_amazon;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class Main {
    public static void main(String[] args) {
        OrderProcessor orderProcessor = new OrderProcessor();
        List<Order> orders = List.of(
                new Order(1),
                new Order(2),
                new Order(3),
                new Order(4),
                new Order(5),
                new Order(6),
                new Order(7),
                new Order(8),
                new Order(9),
                new Order(10)
        );

        log.info("Всего было собрано {} заказов", orderProcessor.processOrder(orders).get());
    }
}
