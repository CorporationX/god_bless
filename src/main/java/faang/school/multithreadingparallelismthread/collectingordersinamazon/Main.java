package faang.school.multithreadingparallelismthread.collectingordersinamazon;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {

    public static void main(String[] args) {

        List<Order> orders = List.of(new Order(0, false),
                new Order(1, false),
                new Order(2, false),
                new Order(3, false),
                new Order(4, false),
                new Order(5, false));

        OrderProcessor orderProcessor = new OrderProcessor();

        List<CompletableFuture<Void>> completableFutures = orders.stream()
                .map(order -> CompletableFuture.runAsync(() -> orderProcessor.processOrder(order)))
                .toList();

        CompletableFuture<Void> completableFuture = CompletableFuture.allOf(completableFutures
                .toArray(new CompletableFuture[0]));

        completableFuture.join();

    }
}
