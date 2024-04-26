package faang.school.godbless.async.task_7;

import faang.school.godbless.async.task_7.model.Order;
import faang.school.godbless.async.task_7.processors.OrderProcessor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    private static final int POOL_SIZE = 5;
    private static final int ORDERS_SIZE = 20;
    private static final ExecutorService EXECUTOR = Executors.newFixedThreadPool(POOL_SIZE);

    public static void main(String[] args) {
        OrderProcessor processor = new OrderProcessor();
        List<Order> orders = getOrders();
        List<CompletableFuture<Integer>> totalOrders = new ArrayList<>();
        orders.forEach(order -> totalOrders.add(processor.processOrder(order, EXECUTOR)));
        EXECUTOR.shutdown();
        CompletableFuture.allOf(totalOrders.toArray(new CompletableFuture[0]))
                .thenAccept((Void) -> System.out.println("обработано заказов: " + processor.getTotalProcessedOrders()));

    }

    public static List<Order> getOrders() {
        List<Order> orders = new ArrayList<>();
        for (int index = 0; index < ORDERS_SIZE; index++) {
            orders.add(new Order(index + 1, false));
        }
        return orders;
    }
}