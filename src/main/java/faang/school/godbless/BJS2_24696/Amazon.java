package faang.school.godbless.BJS2_24696;

import java.util.concurrent.CompletableFuture;

public class Amazon {
    public static void main(String[] args) {
        OrderProcessor orderProcessor = new OrderProcessor();

        Order book = new Order(1);
        Order notebook = new Order(2);
        Order tv = new Order(3);

        CompletableFuture<Integer> orderOne = orderProcessor.processOrder(book);
        CompletableFuture<Integer> orderTwo = orderProcessor.processOrder(notebook);
        CompletableFuture<Integer> orderThree = orderProcessor.processOrder(tv);

        CompletableFuture<Void> orders = CompletableFuture.allOf(orderOne, orderTwo, orderThree);

        orders.thenRun(() ->
                System.out.printf("Всего обработано заказов: %s%n", orderProcessor.getTotalProcessedOrders())).join();
    }
}
