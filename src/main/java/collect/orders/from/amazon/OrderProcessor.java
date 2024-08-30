package collect.orders.from.amazon;

import lombok.Getter;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicInteger;

@Getter
public class OrderProcessor {
    private final AtomicInteger totalProcessedOrders = new AtomicInteger(0);

    public CompletableFuture<Void> processOrder(Order order, ExecutorService executor) {
        return CompletableFuture.runAsync(() -> {
            System.out.println("Приступаем к выполнению заказа: " + order.getId());
            order.setStatus(Status.PROCESSED);

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            order.setStatus(Status.COMPLETED);
            this.totalProcessedOrders.incrementAndGet();

            System.out.println("Заказ выполнен: " + order.getId());
        }, executor);
    }
}
