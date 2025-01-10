package school.faang.sprint4.task50190amazon;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Slf4j
public class OrderProcessor {
    private volatile int totalProcessedOrders;

    public synchronized void processOrder(Order order) {
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            log.warn("Ошибка {}", e);
        }
        order.setStatus("Обработано");
        totalProcessedOrders++;
    }

    public void processAllOrders(List<Order> orders) {
        CompletableFuture<Void> allOrders = CompletableFuture.allOf(
                orders.stream()
                        .map(order -> CompletableFuture.runAsync(() -> processOrder(order)))
                        .toArray(CompletableFuture[]::new)
        );
        allOrders.join();
        System.out.println("Обработано заказов: " + totalProcessedOrders);
    }
}

