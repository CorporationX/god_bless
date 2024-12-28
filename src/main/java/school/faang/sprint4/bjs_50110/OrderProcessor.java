package school.faang.sprint4.bjs_50110;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class OrderProcessor {
    private static final String MESSAGE_OF_THREAD_INTERRUPTED = "Поток был прерван";
    private static final int ORDER_PROCESSING_DELAY_SECONDS = 15;

    private final AtomicInteger totalProcessedOrders = new AtomicInteger(0);

    private CompletableFuture<Void> processOrder(Order order) {
        return CompletableFuture.runAsync(() -> {
            log.info("Началась обработка заказа №{}", order.getId());
            try {
                Thread.sleep(ORDER_PROCESSING_DELAY_SECONDS * 1000);
            } catch (InterruptedException e) {
                log.info(MESSAGE_OF_THREAD_INTERRUPTED);
                Thread.currentThread().interrupt();
            }
            order.setStatus(Status.PROCESSED);
            log.info("Заказ №{} обработан", order.getId());
            totalProcessedOrders.incrementAndGet();
        });
    }

    public void processAllOrders(List<Order> orders) {
        List<CompletableFuture<Void>> futures = orders.stream()
                .map(this::processOrder)
                .toList();

        CompletableFuture.allOf(futures.toArray(CompletableFuture[]::new)).join();

        log.info("Обработанно заказов: {}", totalProcessedOrders);
    }
}
