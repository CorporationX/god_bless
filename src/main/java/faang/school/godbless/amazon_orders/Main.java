package faang.school.godbless.amazon_orders;

import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        Order order1 = new Order(1, "В обработке");
        Order order2 = new Order(2, "В обработке");
        Order order3 = new Order(3, "В обработке");
        OrderProcessor orderProcessor = new OrderProcessor();
        CompletableFuture<Void> future1 = orderProcessor.processOrder(order1);
        CompletableFuture<Void> future2 = orderProcessor.processOrder(order2);
        CompletableFuture<Void> future3 = orderProcessor.processOrder(order3);
        CompletableFuture.allOf(future1,future2,future3).join();
        System.out.println("Всего обработано заказов: " + orderProcessor.totalProcessedOrders.get());
    }
}
