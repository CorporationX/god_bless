package school.faang.task_50019;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class OrderProcessor {
    private final AtomicInteger totalProcessedOrders = new AtomicInteger(0);
    private static final int SLEEP_DURATION = 5000;

    private CompletableFuture<Void> processOrder(Order order, ExecutorService executor) {
        return CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(SLEEP_DURATION);
            } catch (InterruptedException e) {
                log.error(e.getMessage());
            }
            String status = "Обработано";
            order.changeStatus(status);
            System.out.printf("У заказа с id:%s сменился статус на %s%n", order.getId(), status);
            totalProcessedOrders.incrementAndGet();
        }, executor);
    }

    public void processAllOrders(List<Order> orders, ExecutorService executor) {
        List<CompletableFuture<Void>> orderFutures = orders.stream()
                .filter(Objects::nonNull)
                .map(order -> processOrder(order, executor))
                .toList();

        CompletableFuture<?>[] futureArray = orderFutures.toArray(new CompletableFuture[0]);

        CompletableFuture.allOf(futureArray)
                .thenRun(() -> System.out.println("totalProcessedOrders: " + totalProcessedOrders.get()));
    }
}
