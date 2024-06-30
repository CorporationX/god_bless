package faang.school.godbless.amazonorders;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(10);
        OrderProcessor orderProcessor = new OrderProcessor();
        List<Order> orders = new ArrayList<>();

        IntStream.rangeClosed(1, 100)
                .forEach(i -> orders.add(new Order(i)));

        List<CompletableFuture<Void>> futures = new ArrayList<>();

        for (Order order : orders) {
            CompletableFuture<Void> future = orderProcessor.processOrder(order);
            futures.add(future);
        }

        CompletableFuture<Void> allOf = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));
        allOf.join();

        System.out.println("Общее количество обработанных заказов: " + orderProcessor.getTotalProcessedOrders().get());

        executor.shutdown();
    }

}

