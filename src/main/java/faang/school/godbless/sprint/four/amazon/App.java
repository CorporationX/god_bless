package faang.school.godbless.sprint.four.amazon;

import java.util.concurrent.CompletableFuture;

public class App {
    public static void main(String... args) {
        OrderProcessor orderProcessor = new OrderProcessor();
        Order order1 = new Order(1, "NOT PROCESSED");
        Order order2 = new Order(2, "NOT PROCESSED");
        Order order3 = new Order(3, "NOT PROCESSED");

        CompletableFuture<Void> processOrder1 = orderProcessor.processOrder(order1);
        CompletableFuture<Void> processOrder2 = orderProcessor.processOrder(order2);
        CompletableFuture<Void> processOrder3 = orderProcessor.processOrder(order3);

        CompletableFuture.allOf(processOrder1, processOrder2, processOrder3).join();

        System.out.printf("Orders in following amount %d have been processed%n",
                orderProcessor.getTotalProcessedOrders().get());
    }
}
