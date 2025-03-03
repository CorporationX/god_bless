package school.faang.collecting_orders_at_amazon.BJS2_62344;

import lombok.Getter;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
@Getter
public class OrderProcessor {
    private static final int PROCESS_RUNTIME = 3000;

    private final AtomicInteger totalProcessedOrders = new AtomicInteger(0);

    public List<CompletableFuture<Void>> processAllOrders(@NonNull List<Order> orders) {
        return orders.stream().map(this::processOrder).toList();
    }

    private CompletableFuture<Void> processOrder(@NonNull Order order) {
        return CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(PROCESS_RUNTIME);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                log.warn("Выполнение задачи прервано {}", e.getMessage());
                throw new RuntimeException(e);
            }

            order.setStatus(Status.PROCESSED);
            totalProcessedOrders.addAndGet(1);
        });
    }
}
