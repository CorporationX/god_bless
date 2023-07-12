package faang.school.godbless.collectingOrdersAmazon;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Main {
    public static void main(String[] args) {
        OrderProcessor orderProcessor = new OrderProcessor();

        Order order1 = new Order(1, "В обработке");
        Order order2 = new Order(2, "В обработке");
        Order order3 = new Order(3, "В обработке");

        List<Order> orders = Arrays.asList(order1, order2, order3);
        CompletableFuture<?>[] futures = orders.stream()
                .map(orderProcessor::processOrder)
                .toArray(CompletableFuture[]::new);

        CompletableFuture<Void> allFutures = CompletableFuture.allOf(futures);
        allFutures.thenRun(() -> {
            System.out.println("Все заказы обработаны");
            System.out.println("Количество обработанных заказов: " + orderProcessor.getTotalProcessedOrders());
        });

        try {
            allFutures.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

}
