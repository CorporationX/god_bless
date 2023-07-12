package faang.school.godbless.sprint_3.multithreading_future.amazon_orders_collecting;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        OrderProcessor orderProcessor = new OrderProcessor();
        Order firstOrder = new Order(1);
        Order secondOrder = new Order(2);
        Order thirdOrder = new Order(3);
        List<CompletableFuture<Void>> futures = new ArrayList<>();
        futures.add(orderProcessor.processOrder(firstOrder));
        futures.add(orderProcessor.processOrder(secondOrder));
        futures.add(orderProcessor.processOrder(thirdOrder));
        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]))
                .thenAccept(v -> System.out.println(orderProcessor.getTotalProcessedOrders().get()))
                .join();
    }
}