package school.faang.task50441amozon;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
@Getter
@AllArgsConstructor
public class OrderProcessor {
    private final AtomicInteger totalProcessedOrders = new AtomicInteger(0);


    private CompletableFuture<Void> processOrder(Order order) {
        return CompletableFuture.runAsync(() -> {
            try {
                order.changedStatus(OrderStatus.PROCESSED);
                Thread.sleep(Constants.EXECUTION_TIME);
            } catch (InterruptedException e) {
                order.changedStatus(OrderStatus.CANCELED);
                Thread.currentThread().interrupt();
                log.error("Поток был прерван при вызове метода sleep", e);
            }

            totalProcessedOrders.incrementAndGet();
        });
    }

    public void processAllOrders(List<Order> orders) {
        List<CompletableFuture<Void>> processedOrders =
                orders.stream().map(this::processOrder).toList();
        processedOrders.forEach(CompletableFuture::join);
        log.info("Обработано заказов {}", totalProcessedOrders);
    }
}
