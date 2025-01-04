package school.faang.task_50179;

import lombok.Data;
import lombok.Getter;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

public class OrderProcessor {
    private final static AtomicInteger totalProcessedOrders = new AtomicInteger(0);

    public static AtomicInteger getTotalProcessedOrders() {
        int newTotalProcessedOrders = totalProcessedOrders.get();
        return new AtomicInteger(newTotalProcessedOrders);
    }

    public CompletableFuture<Void> processOrder(Order order) {
        return CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(1000);
                order.setStatus("Обработано");
                totalProcessedOrders.addAndGet(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
                throw new RuntimeException();
            }
        });
    }
}
