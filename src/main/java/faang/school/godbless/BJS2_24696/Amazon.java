package faang.school.godbless.BJS2_24696;

import java.util.concurrent.CompletableFuture;

public class Amazon {
    public static void main(String[] args) {
        OrderProcessor orderProcessor = new OrderProcessor();

        Order book = new Order(11);
        Order notebook = new Order(22);
        Order tv = new Order(33);

        CompletableFuture.allOf(
                orderProcessor.processOrder(book),
                orderProcessor.processOrder(notebook),
                orderProcessor.processOrder(tv)
        ).thenRun(() ->
                System.out.printf("Всего обработано заказов: %s%n", orderProcessor.getTotalProcessedOrders())
        ).join();
    }
}
