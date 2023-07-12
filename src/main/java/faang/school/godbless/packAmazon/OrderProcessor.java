package faang.school.godbless.packAmazon;

import lombok.Getter;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

@Getter
public class OrderProcessor {
    private AtomicInteger totalProcessedOrders = new AtomicInteger(0);

    public CompletableFuture<Void> processOrder(Order order) {
        return CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }
            order.setStatus("Обработанно");
            System.out.println("Order №" + order.getId() + " обработан");
            totalProcessedOrders.incrementAndGet();
        });
    }
}
