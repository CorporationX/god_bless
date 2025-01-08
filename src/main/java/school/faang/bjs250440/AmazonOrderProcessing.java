package school.faang.bjs250440;

import lombok.val;

import java.util.List;

public class AmazonOrderProcessing {

    public static void main(String[] args) {
        OrderProcessor processor = new OrderProcessor();

        List<Order> orders = List.of(
                new Order(1, OrderStatus.NEW),
                new Order(2, OrderStatus.NEW),
                new Order(3, OrderStatus.NEW)
        );
        val processedOrders = processor.processAllOrders(orders);
        System.out.println("Обработано заказов: " + processedOrders);
    }
}
