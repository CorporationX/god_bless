package faang.school.godbless.multithreading_async.task_7;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    private static final int ORDER_COUNT = 10;

    public static void main(String[] args) {
        final OrderProcessor orderProcessor = new OrderProcessor();
        final List<Order> orders = getOrders();
        final ExecutorService executor = Executors.newFixedThreadPool(orders.size());
        orderProcessor.processAllOrders(orders, executor);
        executor.shutdown();
    }

    private static List<Order> getOrders() {
        final List<Order> orders = new ArrayList<>();
        for (int i = 0; i < ORDER_COUNT; i++) {
            orders.add(new Order(i));
        }
        return orders;
    }
}

