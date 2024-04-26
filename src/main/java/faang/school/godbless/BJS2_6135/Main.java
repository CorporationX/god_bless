package faang.school.godbless.BJS2_6135;

import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        OrderProcessor orderProcessor = new OrderProcessor();

        Order order1 = new Order(1, "to do");
        Order order2 = new Order(2, "to do");
        Order order3 = new Order(3, "to do");
        Order order4 = new Order(4, "to do");

        CompletableFuture.allOf(orderProcessor.processOrder(order1),
                orderProcessor.processOrder(order2),
                orderProcessor.processOrder(order3),
                orderProcessor.processOrder(order4)).join();

        System.out.println(orderProcessor.getTotalProcessedOrders().get());
    }
}
