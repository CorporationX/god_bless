package ordersAmazon_1275;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

@Data
@AllArgsConstructor
public class OrderProcessor {
    private AtomicInteger totalProcessedOrders;

    public CompletableFuture<Integer> processOrder(Order order) {
        return CompletableFuture.supplyAsync(() -> {
                    try {
                        System.out.println("Начинается обработка заказа - " + order.getId());
                        Thread.sleep(2000);
                        order.setStatus("Обработан");
                        System.out.printf("Заказ %s %s \n", order.getId(), order.getStatus());
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    return totalProcessedOrders.incrementAndGet();
                }
        );
    }
}