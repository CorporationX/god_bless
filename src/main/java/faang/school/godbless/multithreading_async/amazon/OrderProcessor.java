package faang.school.godbless.multithreading_async.amazon;

import lombok.Getter;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

@Getter
public class OrderProcessor {
    private static final AtomicInteger totalProcessedOrders = new AtomicInteger(0);

    public static CompletableFuture<Void> processOrder(Order order) {
        return CompletableFuture.runAsync(() -> {
            System.out.println("Обрабатываю заказ, id заказа: " + order.getId());
            try {
                Thread.sleep(7000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            order.setStatus("Обработано");
            totalProcessedOrders.incrementAndGet();
        });
    }

    public static AtomicInteger totalProcessedOrders(){
        return totalProcessedOrders;
    }
}
