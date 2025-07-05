package school.faang.bjs282230;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class AmazonOrderProcessing {
    public static void main(String[] args) {
        log.info("Запуск системы обработки заказов Amazon");

        OrderProcessor processor = new OrderProcessor();

        List<Order> orders = List.of(
                new Order(1, "Новый"),
                new Order(2, "Новый"),
                new Order(3, "Новый")
        );

        log.info("Создано {} заказов для обработки", orders.size());

        processor.processAllOrders(orders);

        log.info("Проверка финальных статусов заказов:");
        orders.forEach(order -> log.info("Заказ: {}", order));

        log.info("Система обработки заказов завершила работу");
    }
}
