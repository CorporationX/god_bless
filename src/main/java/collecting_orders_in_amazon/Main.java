package collecting_orders_in_amazon;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

import static collecting_orders_in_amazon.OrderProcessor.processOrder;

public class Main {
    public static void main(String[] args) {
        AtomicInteger totalProcessedOrders = new AtomicInteger(0);

        Order order1 = new Order(1, "Waiting");
        Order order2 = new Order(2, "Waiting");
        Order order3 = new Order(3, "Waiting");
        Order order4 = new Order(4, "Waiting");

        CompletableFuture<Void> processOrder1 = CompletableFuture.runAsync(() -> processOrder(order1, totalProcessedOrders));
        CompletableFuture<Void> processOrder2 = CompletableFuture.runAsync(() -> processOrder(order2, totalProcessedOrders));
        CompletableFuture<Void> processOrder3 = CompletableFuture.runAsync(() -> processOrder(order3, totalProcessedOrders));
        CompletableFuture<Void> processOrder4 = CompletableFuture.runAsync(() -> processOrder(order4, totalProcessedOrders));

        CompletableFuture.allOf(processOrder1, processOrder2, processOrder3, processOrder4)
                .join();

        int processedOrders = totalProcessedOrders.get();
        System.out.println("Total number of processed orders: " + processedOrders);
    }
}
