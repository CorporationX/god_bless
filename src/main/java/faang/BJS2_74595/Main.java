package faang.BJS2_74595;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {
    private static final int ORDERS_COUNT = 10;

    public static void main(String[] args) {
        final OrderProcessor orderProcessor = new OrderProcessor();
        final List<CompletableFuture<Order>> processedOrders = new ArrayList<>();

        for (int i = 0; i < ORDERS_COUNT; i++) {
            CompletableFuture<Order> processedOrder = orderProcessor.processOrder(new Order(i, "not processed"));
            processedOrders.add(processedOrder);
        }

        CompletableFuture.allOf(processedOrders.toArray(new CompletableFuture[0])).join();
        final int orderedProcessCount = processedOrders.size();
        System.out.println(orderedProcessCount + " orders processed");
    }
}

