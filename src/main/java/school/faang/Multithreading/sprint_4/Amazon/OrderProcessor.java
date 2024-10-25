package school.faang.Multithreading.sprint_4.Amazon;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class OrderProcessor {
    public final static long TIME_PROCESS = 3_000;
    private final AtomicInteger totalProcessedOrders = new AtomicInteger(0);

    public void processAllOrders(List<Order> orders) {
        List<CompletableFuture<Void>> futures = orders.stream()
                .map(order -> processOrder(order)) // Асинхронная обработка каждого заказа
                .toList();

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();

        System.out.println("Обработано заказов: " + totalProcessedOrders.get());
    }

    public CompletableFuture<Void> processOrder(Order order) {
        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(TIME_PROCESS);
            } catch (InterruptedException e) {
                log.error("Ошыыыыбка", e);
                throw new RuntimeException(e);
            }

            order.setStatus(OrderStatus.PROCESSED);
            totalProcessedOrders.incrementAndGet();
        });

        return future;
    }

}

