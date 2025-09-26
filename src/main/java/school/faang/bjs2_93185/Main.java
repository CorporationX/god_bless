package school.faang.bjs2_93185;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

import static school.faang.bjs2_93185.TypeOrder.NEW;

@Slf4j
public class Main {
    public static void main(String[] args) {
        OrderProcessor orderProcessor = new OrderProcessor();

        List<Order> orders = List.of(
                new Order(1, NEW),
                new Order(2, NEW),
                new Order(3, NEW)
        );

        orderProcessor.processAllOrders(orders);

        log.info("Всего заказов - {}", orderProcessor.totalProcessedOrders());
    }
}
