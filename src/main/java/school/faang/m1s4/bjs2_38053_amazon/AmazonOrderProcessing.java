package school.faang.m1s4.bjs2_38053_amazon;

import java.util.List;

public class AmazonOrderProcessing {
    public static void main(String[] args) {
        OrderProcessor processor = new OrderProcessor();

        // Создание списка заказов
        List<Order> orders = List.of(
                new Order(1, "Новый"),
                new Order(2, "Новый"),
                new Order(3, "Новый")
        );

        processor.processAllOrders(orders);
    }
}

