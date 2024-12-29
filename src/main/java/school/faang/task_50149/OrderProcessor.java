package school.faang.task_50149;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class OrderProcessor {
    private static final long EXECUTION_TIME = 2000;
    private final AtomicInteger totalProcessedOrders;

    public OrderProcessor() {
        this.totalProcessedOrders = new AtomicInteger(0);
    }

    public void processAllOrders(List<Order> orders) {
        List<CompletableFuture<Void>> processedOrders = orders.stream().map(this::processOrder).toList();
        processedOrders.forEach(CompletableFuture::join);

        log.info("Обработано заказов: {}", totalProcessedOrders);
    }

    private CompletableFuture<Void> processOrder(Order order) {
        return CompletableFuture.runAsync(() -> {
            try {
                order.changeStatus(StatusOrder.PROCESSED);
                Thread.sleep(EXECUTION_TIME);
            } catch (InterruptedException e) {
                order.changeStatus(StatusOrder.CANCELED);
                Thread.currentThread().interrupt();
                log.error("Поток был прерван при выполнении метода sleep()", e);
            }

            totalProcessedOrders.getAndIncrement();
        });
    }
}
