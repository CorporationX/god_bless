package orders_for_amazon;

import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        OrderProcessor orderProcessor = new OrderProcessor();

        Order order1 = new Order(1, "Pending");
        Order order2 = new Order(2, "Pending");
        Order order3 = new Order(3, "Pending");

        CompletableFuture<Void> processOrder1 = orderProcessor.processOrder(order1);
        CompletableFuture<Void> processOrder2 = orderProcessor.processOrder(order2);
        CompletableFuture<Void> processOrder3 = orderProcessor.processOrder(order3);

        CompletableFuture<Void> allOrdersProcessed = CompletableFuture.allOf(processOrder1, processOrder2, processOrder3);

        allOrdersProcessed.thenRun(() -> {
            System.out.println("Total processed orders: " + orderProcessor.getTotalProcessedOrders());
        }).join();
    }
}
