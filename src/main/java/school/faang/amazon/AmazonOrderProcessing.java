package school.faang.amazon;

import java.util.List;

import static school.faang.amazon.OrderStatus.NEW;

public class AmazonOrderProcessing {
    public static void main(String[] args) {
        OrderProcessor processor = new OrderProcessor();

        // Создание списка заказов
        List<Order> orders = List.of(
                new Order(1, NEW),
                new Order(2, NEW),
                new Order(3, NEW)
        );

        // Обработка заказов
        processor.processAllOrders(orders);
    }
}