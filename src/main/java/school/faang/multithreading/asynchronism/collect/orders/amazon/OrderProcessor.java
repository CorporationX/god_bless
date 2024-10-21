package school.faang.multithreading.asynchronism.collect.orders.amazon;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class OrderProcessor {
    private static final int TIME_FOR_SLEEP_FROM = 5000;
    private static final int TIME_FOR_SLEEP_TO = 10001;

    private final AtomicInteger totalProcessedOrders = new AtomicInteger(0);

    public void processAllOrders(List<Order> orders) {
        ExecutorService executor = Executors.newFixedThreadPool(orders.size());
        log.info("Начинаем асинхронную обработку заказов");
        List<CompletableFuture<Order>> waitingForResult = new ArrayList<>();
        orders.forEach(order -> {
            waitingForResult.add(
                    CompletableFuture.supplyAsync(() -> {
                        processOrder(order);
                        return order;
                    }, executor));
        });
        CompletableFuture.allOf(waitingForResult.toArray(new CompletableFuture[0]))
                .thenRun(() -> log.info("Общее количество обработанных заказов: {}", totalProcessedOrders.get()));
        executor.shutdown();
    }

    private void processOrder(Order order) {
        try {
            log.info("Начинаем обработку заказа №: {}", order.getId());
            Thread.sleep(ThreadLocalRandom.current().nextInt(TIME_FOR_SLEEP_FROM, TIME_FOR_SLEEP_TO));
            order.setStatus(OrderStatus.PROCESSED);
            totalProcessedOrders.getAndIncrement();
            log.info("Заказ №: {} успешно обработан, количество обработанных заказов: {}", order.getId(), totalProcessedOrders.get());
        } catch (InterruptedException e) {
            order.setStatus(OrderStatus.CANCELED);
            throw new RuntimeException(e);
        }
    }
}
