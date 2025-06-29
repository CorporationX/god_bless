package school.faang.module4.amazon;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

@Slf4j
public class OrderProcessor {
    private static final long ORDER_PROCESS_TIME_IN_MS = 3_000L;
    private final AtomicInteger totalProcessedOrders = new AtomicInteger();

    public void processOrder(Order order) {
        synchronized (order) {
            if (Status.PROCESSED.equals(order.getStatus())) {
                log.info("order {} is already processed", order.getId());
                return;
            }
            log.info("start processing order {}", order.getId());
            try {
                Thread.sleep(ORDER_PROCESS_TIME_IN_MS);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
            order.setStatus(Status.PROCESSED);
            totalProcessedOrders.incrementAndGet();
            log.info("end processing order {}", order.getId());
        }
    }

    public void processAllOrders(@NonNull List<Order> orders) {
        if (orders.isEmpty()) {
            throw new IllegalArgumentException("orders is empty");
        }

        List<CompletableFuture<Void>> completableFutures = new ArrayList<>();
        orders.forEach(order ->
                completableFutures.add(
                        CompletableFuture.runAsync(() -> processOrder(order))
                ));

        completableFutures.forEach(CompletableFuture::join);
        log.info("total processed orders = {}", totalProcessedOrders.get());
    }
}
