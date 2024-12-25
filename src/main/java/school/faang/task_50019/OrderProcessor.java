package school.faang.task_50019;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class OrderProcessor {
    private final AtomicInteger totalProcessedOrders = new AtomicInteger(0);
    private static final int SLEEP_DURATION = 5000;

    private CompletableFuture<Void> processOrder(Order order) {
        return CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(SLEEP_DURATION);
            } catch (InterruptedException e) {
                log.error(e.getMessage());
            }
            order.changeStatus("Обработано");
            totalProcessedOrders.addAndGet(1);
        });
    }

    public void processAllOrders(List<Order> orders) {
        List<CompletableFuture<Void>> orderFutures = orders.forEach(order -> {
            return processOrder(order);
        });
    }
}
