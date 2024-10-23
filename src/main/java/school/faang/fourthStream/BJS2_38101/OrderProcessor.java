package school.faang.fourthStream.BJS2_38101;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class OrderProcessor {
    private final static AtomicInteger TOTAL_PROCESSED_ORDERS = new AtomicInteger(0);
    private final static int TREAD_SLEEP_TIME = 5_000;
    private static final long TERMINATION_SECONDS = 30;

    public void processAllOrders(List<Order> orders) {
        ExecutorService executor = Executors.newFixedThreadPool(orders.size());

        List<CompletableFuture<Void>> futures = orders.stream()
                .map(order -> CompletableFuture.runAsync(() -> processOrder(order), executor))
                .toList();

        futures.forEach(CompletableFuture::join);

        shutdown(executor);
        log.info("Обработано заказов: {}\n", TOTAL_PROCESSED_ORDERS.get());
    }

    private void processOrder(Order order) {
        try {
            Thread.sleep(TREAD_SLEEP_TIME);
            order.setStatus(OrderStatus.PROCESSING);
            TOTAL_PROCESSED_ORDERS.addAndGet(1);
        } catch (InterruptedException e) {
            log.warn("Упс... Процесс обработки заказа {} был прерван. Информация: {}", order.getId(), e.getMessage());
            Thread.currentThread().interrupt();
        }

        log.info("Заказ {} обработан. Статус: {}\n", order.getId(), order.getStatus());
    }

    private void shutdown(ExecutorService executor) {
        executor.shutdown();
        try {
            if (!executor.awaitTermination(TERMINATION_SECONDS, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.warn("Поток был прерван", e);
            Thread.currentThread().interrupt();
        }
    }
}
