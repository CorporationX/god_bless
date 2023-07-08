package Multithreading.bc3333_Collecting_Orders_from_Amazon;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Application {
    public static void main(String[] args) {
        OrderProcessor orderProcessor = new OrderProcessor();

        List<Order> orders = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            Order order = new Order(i, "Order" + i);
            orders.add(order);
            System.out.println("Add Order: ID: " + order.getId() + " Status: new " + order.getStatus());
        }
        System.out.println();

        List<CompletableFuture<Order>> futureOrders = orders.stream()
                .map(orderProcessor::processOrder)
                .toList();

        CompletableFuture.allOf(futureOrders.toArray(new CompletableFuture[0]))
                .thenRun(() -> {
                    futureOrders.stream().map(CompletableFuture::join)
                            .forEach(order -> System.out.println("Get Order: ID: " + order.getId() + " Status: " + order.getStatus()));
                    System.out.println("Number of processed orders: " + orderProcessor.getTotalProcessedOrders());
                }).join();
        System.out.println("Finished");
    }
}
