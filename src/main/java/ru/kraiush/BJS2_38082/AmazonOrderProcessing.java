package ru.kraiush.BJS2_38082;

import java.util.List;

public class AmazonOrderProcessing {
    public static void main(String[] args) {
        OrderProcessor processor = new OrderProcessor();

        List<Order> orders = List.of(
                new Order(1),
                new Order(2),
                new Order(3),
                new Order(4),
                new Order(5)
        );

        processor.processAllOrders(orders);
    }
}
