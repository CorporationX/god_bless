package amazonorders;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        OrderProcessor orderProcessor = new OrderProcessor();
        List<Order> orders = List.of(
                new Order(1, OrderStatus.NEW),
                new Order(2, OrderStatus.NEW),
                new Order(3, OrderStatus.NEW)
        );
        System.out.printf("Обработано заказов: %d \n", orderProcessor.processAllOrders(orders));
    }
}