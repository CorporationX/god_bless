package school.faang.sprint_4.task_43574;

import lombok.Data;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

@Data
public class OrderProcessor {
    private static final int THREAD_SLEEP = 3_000;

    private final AtomicInteger totalProcessedOrders = new AtomicInteger(0);

    public CompletableFuture<Void> processOrder(Order order) {
        return CompletableFuture.runAsync(() -> {
            System.out.println("Обрабатывается заказ с id: " + order.getId());
            try {
                Thread.sleep(THREAD_SLEEP);
            } catch (InterruptedException e) {
                System.out.println("Обработка заказа была прервана!");
            }
            order.setStatus(Status.PROCESSED);
            totalProcessedOrders.incrementAndGet();
            System.out.println("Заказ с id: " + order.getId() + " обработан!");
        });
    }
}