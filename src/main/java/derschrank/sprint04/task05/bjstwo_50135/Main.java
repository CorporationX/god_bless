package derschrank.sprint04.task05.bjstwo_50135;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        OrderProcessor processor = new OrderProcessor();

        // Создание списка заказов
        List<Order> orders = getOrders(100);

        // Обработка заказов
        int count = processor.processAllOrders(orders);
        System.out.println("Total count of order, was processed: " + count);
    }

    private static List<Order> getOrders(int count) {
        List<Order> orders = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            orders.add(new Order(i, Status.NEW));
        }
        return orders;
    }
}
