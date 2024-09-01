package faang.school.godbless.collecting_orders_on_amazon;

import lombok.Getter;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

@Getter
public class OrderProcessor {

    private static AtomicInteger totalProcessedOrders = new AtomicInteger();
    private final int SLEEP_TIME = 3000;
    private final String STATUS = "Обработано";

    public CompletableFuture<Void> processOrder(Order order) {
        return CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(SLEEP_TIME);
            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }

            order.setStatus(STATUS);
            totalProcessedOrders.incrementAndGet();
        });
    }

    public int getTotalProcessedOrders() {
        return totalProcessedOrders.get();
    }
}
