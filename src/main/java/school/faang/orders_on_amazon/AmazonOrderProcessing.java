package school.faang.orders_on_amazon;

import java.util.List;

/**
 * Проект: god_bless
 * Класс AmazonOrderProcessing
 * Автор: Vital
 */

public class AmazonOrderProcessing {
    public static void main(String[] args) {
        OrderProcessor processor = new OrderProcessor();

        //Создание списка заказов
        List<Order> orders = List.of(
                new Order(1, OrderStatus.NEW),
                new Order(2, OrderStatus.NEW),
                new Order(3, OrderStatus.NEW),
                new Order(4, OrderStatus.NEW),
                new Order(5, OrderStatus.NEW)
        );

        //Асинхронная обработка всех заказов
        processor.processAllOrders(orders);

        //Дополнительно выводим статус каждого заказа
        System.out.println("\nСтатусы заказов после обработки:");
        orders.forEach(order ->
                System.out.println("Заказ " + order.getId() + ": " + order.getStatus())
        );
    }
}