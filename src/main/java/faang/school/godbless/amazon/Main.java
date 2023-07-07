package faang.school.godbless.amazon;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        OrderProcessor orderProcessor = new OrderProcessor();
        List<CompletableFuture<Order>> futuresOrders = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            orderProcessor.addOrder(new Order(i + 1));
        }

        for (Order order : orderProcessor.getOrders()) {
            CompletableFuture<Order> orderCompletableFuture = orderProcessor.processOrder(order);
            futuresOrders.add(orderCompletableFuture);
        }

        CompletableFuture.allOf(futuresOrders.toArray(new CompletableFuture[0]))
                .join();

        System.out.println(OrderProcessor.totalProcessedOrders);
    }
}
