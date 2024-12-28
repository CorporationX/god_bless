package school.faang.amazon_orders;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

public class OrderProcessor {
    private AtomicInteger totalProcessedOrders = new AtomicInteger(0);
    public void processAllOrders(List<Order> orders) {
        CompletableFuture[] futures = orders.stream().map(order -> CompletableFuture.supplyAsync(() -> processOrder(order))).toArray(CompletableFuture[]::new);
        while (!CompletableFuture.allOf(futures).isDone()) {
            System.out.println("Обработка...");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Обработано заказов: " + totalProcessedOrders);
    }

    private boolean processOrder(Order order) {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            System.out.println("Прервано");
            return false;
        }
        totalProcessedOrders.getAndIncrement();
        return true;
    }
}
