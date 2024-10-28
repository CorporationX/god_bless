package school.faang.AmazonOrders;

import java.util.List;

public class AmazonOrderProcessing {
    public static void main(String[] args) {
        OrderProcessor processor = new OrderProcessor();

        // Создание списка заказов
        List<Order> orders = List.of(
                new Order(1),
                new Order(2),
                new Order(3)
        );

        // Обработка заказов
        processor.processAllOrders(orders);
    }
}
