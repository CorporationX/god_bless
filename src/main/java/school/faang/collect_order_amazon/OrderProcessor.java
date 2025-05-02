package school.faang.collect_order_amazon;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class OrderProcessor {
    private final AtomicInteger totalProcessedOrders = new AtomicInteger(0);
    private static final int FIXED_THREAD = 3;
    private static final Random RANDOM = new Random();

    private void plusTotalOrders() {
        totalProcessedOrders.incrementAndGet();
    }

    public AtomicInteger processOrder(List<Order> orders) {
        ExecutorService service = Executors.newFixedThreadPool(FIXED_THREAD);

        List<CompletableFuture<Void>> completableFutureList = orders.stream()
                .map(order -> processing(order, service))
                .toList();

        CompletableFuture<Void> allOf =
                CompletableFuture.allOf(completableFutureList.toArray(new CompletableFuture[0]));
        allOf.join();

        service.shutdown();
        return totalProcessedOrders;
    }

    private CompletableFuture<Void> processing(Order order, ExecutorService service) {
        return CompletableFuture.runAsync(() -> {
            log.info("Отправка заказа {} началась", order.getId());

            try {
                Thread.sleep(RANDOM.nextLong(10000) + 100);
                order.setFinished(true);
                plusTotalOrders();
                log.info("Заказ {} отправился", order.getId());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException("Error!!!!!!!!!!!!!!!!!!");
            }
        }, service);
    }
}
