package school.faang.orders;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class OrderProcessor {
    private AtomicInteger totalProcessedOrders = new AtomicInteger(0);

    public CompletableFuture<Void> processOrder(Order order) {
        return CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                log.error("Поток был прерван.");
                Thread.currentThread().interrupt();
            }

            order.setStatus("Обработано");
            totalProcessedOrders.incrementAndGet();
        });
    }

    public void processAllOrders(List<Order> orders) {
        List<CompletableFuture<Void>> futureList = orders.stream()
                .map(this::processOrder)
                .toList();

        CompletableFuture.allOf(futureList.toArray(new CompletableFuture[0])).join();
        log.info("Количество обработанных заказов: {}", totalProcessedOrders);
    }
}
