package collect.orders.from.amazon;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    private final static int ORDERS_COUNT = 999;

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(ORDERS_COUNT);
        OrderProcessor processor = new OrderProcessor();
        List<Order> orders = new ArrayList<>();

        for (long i = 1; i <= ORDERS_COUNT; i++) {
            orders.add(new Order());
        }

        List<CompletableFuture<Void>> futures = orders.stream()
            .map((order) -> processor.processOrder(order, executor))
            .toList();

        executor.shutdown();
        CompletableFuture.allOf(futures.toArray(CompletableFuture[]::new)).join();

        System.out.println("Обработано заказов: " + processor.getTotalProcessedOrders());
    }
}
