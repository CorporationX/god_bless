package school.faang.bjs2_82216;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class OrderProcessor {
    private final Random rand = new Random();
    private final ExecutorService executorService = Executors.newFixedThreadPool(3);
    private final AtomicInteger totalProcessedOrders = new AtomicInteger(0);

    public CompletableFuture<Void> processOrder(Order order) {
        log.info("Началась обработка заказа {}", order.getId());

        return CompletableFuture.runAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(rand.nextInt(3, 5));
                order.setStatus(OrderStatus.PROCESSED);
                totalProcessedOrders.incrementAndGet();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                log.error("Ошибка при обработке заказа {}", order.getId());
                throw new CompletionException("Ошибка при обработке заказа:", e);
            }
        }, executorService);
    }

    public void processAllOrders(List<Order> orders) {
        List<CompletableFuture<Void>> futures = orders.stream()
                .map(this::processOrder)
                .toList();

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();
        log.info("Обработано заказов: {}", totalProcessedOrders.get());

        executorService.shutdown();
    }
}
