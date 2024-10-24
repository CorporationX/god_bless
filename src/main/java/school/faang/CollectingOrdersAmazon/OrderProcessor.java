package school.faang.CollectingOrdersAmazon;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class OrderProcessor {
    private final AtomicInteger totalProcessedOrders = new AtomicInteger(0);

    private final int TIME_OF_PROCESS_ORDER = 5_000;

    private final int THREAD_POOL_SIZE = 10;
    private final ExecutorService executorService = Executors.newFixedThreadPool(THREAD_POOL_SIZE);

    public void processAllOrders(List<Order> orders) {
        List<CompletableFuture<Void>> futures = orders.stream()
                .map(order -> CompletableFuture
                        .runAsync(() -> processOrder(order), executorService)
                        .exceptionally(e -> {
                            log.error("Обработка заказа завершилась неудачно: {}", e.getMessage());
                            executorService.shutdownNow();
                            throw new IllegalStateException(e);
                        }))
                .toList();

        CompletableFuture<Void> allOrders = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));
        allOrders.thenRun(() -> System.out.printf("обработано заказов: %s\n", totalProcessedOrders));
    }

    public void shutdown() {
        executorService.shutdown();
    }

    private void processOrder(Order order) {
        try {
            Thread.sleep(TIME_OF_PROCESS_ORDER);
        } catch (InterruptedException e) {
            order.setStatus("Failed");

            log.error("Ошибка обработки заказа {}: {}", order.getId(), e.getMessage());
            throw new IllegalStateException(e);
        }

        totalProcessedOrders.incrementAndGet();
        order.setStatus("Processed");
    }
}
