package faang.school.godbless.collecting_orders_from_amazon;

import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        OrderProcessor orderProcessor = new OrderProcessor();

        ExecutorService executorService = Executors.newFixedThreadPool(10);

        CompletableFuture<Void>[] futures = new CompletableFuture[10];
        ArrayList<Order> orders = new ArrayList<>();
        for(int i = 0; i < 10; i++) {
            Order order = new Order(i);
            orders.add(order);
            CompletableFuture<Void> future = orderProcessor.processOrder(order, executorService);
            futures[i] = future;
        }

        CompletableFuture<Void> allFutures = CompletableFuture.allOf(futures);
        allFutures.join();
        executorService.shutdown();

        System.out.println(orderProcessor.getTotalProcessorOrders().get());
        orders.stream().forEach(order -> System.out.println("Order-" + order.getId() + " " + order.getStatus()));
    }
}
