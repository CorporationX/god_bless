package faang.school.godbless.amazonorders;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        List<Order> orders = List.of(
                new Order(1, "prepare"),
                new Order(2, "prepare"),
                new Order(3, "prepare"),
                new Order(4, "prepare"),
                new Order(5, "prepare"),
                new Order(6, "prepare")
        );
        OrderProcessor processor = new OrderProcessor();
        List<CompletableFuture<Void>> ordersList = new ArrayList<>();
        orders.forEach(order -> ordersList.add(processor.processOrder(order)));
        CompletableFuture.allOf(ordersList.toArray(CompletableFuture[]::new)).join();
        processor.getExecutorService().shutdown();
        try {
            processor.getExecutorService().awaitTermination(60L, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(processor.getTotalProcessedOrders());
    }
}
