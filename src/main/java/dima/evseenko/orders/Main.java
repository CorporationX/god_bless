package dima.evseenko.orders;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        OrderProcessor processor = new OrderProcessor();

        List<Order> orders = new ArrayList<>(getOrders());

        processor.processAllOrders(orders);

        System.out.println(orders);
        Thread.sleep(5000);
        System.out.println(orders);
    }

    private static List<Order> getOrders() {
        return List.of(
                new Order(1, Status.NEW),
                new Order(2, Status.NEW),
                new Order(3, Status.NEW)
        );
    }
}
