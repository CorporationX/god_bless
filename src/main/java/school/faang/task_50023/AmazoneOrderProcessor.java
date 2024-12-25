package school.faang.task_50023;

import java.util.List;

public class AmazoneOrderProcessor {
    public static void main(String[] args) {
        OrderProcessor processor = new OrderProcessor();

        // Создание списка заказов
        List<Order> orders = List.of(
                new Order(1, "Новый"),
                new Order(2, "Новый"),
                new Order(3, "Новый")
        );

        // Обработка заказов
        processor.processAllOrders(orders);
        processor.shutdownExecutor();
    }
}
