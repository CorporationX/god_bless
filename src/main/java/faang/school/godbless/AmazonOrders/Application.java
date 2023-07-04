package faang.school.godbless.AmazonOrders;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Application {
    public static void main(String[] args) {
        Order order1 = new Order(1, false);
        Order order2 = new Order(2, false);
        Order order3 = new Order(3, false);
        Order order4 = new Order(4, false);
        Order order5 = new Order(5, false);
        Order order6 = new Order(6, false);

        OrderProcessor orderProcessor = new OrderProcessor();
        List<Order> orders = List.of(order1, order2, order3, order4, order5, order6);
        List<CompletableFuture<Void>> futureList= orders.stream().map(orderProcessor::processedOrders).toList();

        CompletableFuture.allOf(futureList.toArray(new CompletableFuture[0])).join();

        System.out.println(orderProcessor.getTotalProcessedOrders());
    }
}
