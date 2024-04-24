package faang.school.godbless.amazon;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static faang.school.godbless.amazon.OrderProcessor.processOrder;

public class Main {

    public static void main(String[] args) {
        OrderProcessor orderProcessor = new OrderProcessor();

        List<Order> orders = List.of(new Order(1), new Order(2), new Order(3), new Order(4), new Order(5));
        ExecutorService pool = Executors.newFixedThreadPool(orders.size());

        List<CompletableFuture<Void>> futures = orders.stream()
                .map((order)->processOrder(order, pool))
                .toList();

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();
        pool.shutdown();

        System.out.println("Total processed orders: " + orderProcessor.getTotalProcessedOrders());
    }
}
