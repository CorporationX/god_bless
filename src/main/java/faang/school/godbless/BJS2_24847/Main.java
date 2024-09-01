package faang.school.godbless.BJS2_24847;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Main {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        List<Order> orders = List.of(new Order(1, "Требует обработки"),
                new Order(2, "Требует обработки"),
                new Order(3, "Требует обработки"),
                new Order(4, "Требует обработки"));

        OrderProcessor orderProcessor = new OrderProcessor();

        CompletableFuture<Void> future = CompletableFuture.allOf(
                orders.stream()
                        .map(orderProcessor::processOrder)
                        .toArray(CompletableFuture[]::new));
        future.get();
        System.out.println(orderProcessor.getTotalProcessedOrders().get());
    }
}
