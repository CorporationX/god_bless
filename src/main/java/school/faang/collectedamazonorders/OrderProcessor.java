package school.faang.collectedamazonorders;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class OrderProcessor {
    private static final AtomicInteger totalProcessedOrders = new AtomicInteger(0);
    private static final int TIMEOUT_ONE_SECOND = 1_000;

    private CompletableFuture<Void> processOrder(Order order) {
        return CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(TIMEOUT_ONE_SECOND);
                String status = "Обработано";
                order.setStatus(status);
                totalProcessedOrders.addAndGet(1);
                log.info("Статус заказа изменен на '{}'", status);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                log.error(e.getMessage(), e);
            }
        });
    }

    public void processAllOrders(List<Order> orders) {
        List<CompletableFuture<Void>> result = orders.stream()
                .map(this::processOrder)
                .toList();

        CompletableFuture.allOf(result.toArray(new CompletableFuture[0])).join();
        log.info("Обработано заказов: {}", totalProcessedOrders.get());
    }
}

