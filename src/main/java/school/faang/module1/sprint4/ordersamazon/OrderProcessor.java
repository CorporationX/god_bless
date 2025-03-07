package school.faang.module1.sprint4.ordersamazon;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
@Data
public class OrderProcessor {
    private OrderStatus status;
    private final AtomicInteger totalProcessedOrders = new AtomicInteger(0);
    private static final int ORDER_PROCESSING_TIME_MS = 5000;

    public CompletableFuture<AtomicInteger> processOrder(Order order) {
        order.setStatus(OrderStatus.PROCESSING);
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(ORDER_PROCESSING_TIME_MS);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException("Поток был прерван при обработке заказов", e);
            }

            order.setStatus(OrderStatus.SHIPPED);
            totalProcessedOrders.getAndIncrement();
            return new AtomicInteger(1);
        });
    }

    public void processAllOrders(List<Order> orders) {
        CompletableFuture<?>[] resultProcessedOrders = orders.stream()
                .map(this::processOrder)
                .toArray(CompletableFuture[]::new);

        CompletableFuture<Integer> totalResult = CompletableFuture.allOf(resultProcessedOrders)
                .thenApply(result -> {
                    int sumResult;
                    sumResult = Arrays.stream(resultProcessedOrders)
                            .mapToInt(count -> {
                                try {
                                    return ((AtomicInteger) count.get()).intValue();
                                } catch (InterruptedException | ExecutionException e) {
                                    throw new RuntimeException(e.getMessage(), e);
                                }
                            }).sum();
                    return sumResult;
                });
        try {
            int totalResultOrders;
            totalResultOrders = totalResult.get();

            log.info("Обработано заказов: {}", totalResultOrders);
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }
}
