package school.faang.amazon;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class OrderProcessor {
    private static final int PROCESSING_TIME_MIN_MS = 0;
    private static final int PROCESSING_TIME_MAX_MS = 5000;

    private final AtomicInteger totalProcessedOrders = new AtomicInteger(0);
    private final ExecutorService executor = Executors.newFixedThreadPool(4);

    public CompletableFuture<Void> processOrder(Order order) {
        return CompletableFuture.runAsync(() -> {
            try {
                int processingTime = ThreadLocalRandom.current().nextInt(PROCESSING_TIME_MIN_MS,
                        PROCESSING_TIME_MAX_MS);
                Thread.sleep(processingTime);

                order.setStatus("Обработано");
                int currentCount = totalProcessedOrders.incrementAndGet();

                log.info("Заказ #{} обработан за {} мс (всего обработано: {})",
                        order.getId(), processingTime, currentCount);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                log.error("Прерывание при обработке заказа #{}", order.getId(), e);
                throw new RuntimeException("Обработка заказа прервана", e);
            }
        }, executor);
    }

    public void processAllOrders(List<Order> orders) {
        List<CompletableFuture<Void>> futures = orders.stream()
                .map(this::processOrder)
                .toList();

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]))
                .thenRun(executor::shutdown)
                .join();
    }
}
