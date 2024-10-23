package amazon;

import org.w3c.dom.ls.LSOutput;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Order> orders = List.of(
                new Order(1),
                new Order(2),
                new Order(3));
        OrderProcessor orderProcessor = new OrderProcessor();
        List<CompletableFuture<Void>> futures = orders.stream()
                .map(order -> orderProcessor.processOrder(order))
                .collect(Collectors.toList());


        CompletableFuture<Void> allTask = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));
        allTask.thenRun(() -> System.out.println("totalProcessedOrders = " + orderProcessor.getTotalProcessedOrders()));
        allTask.join();
    }
}
