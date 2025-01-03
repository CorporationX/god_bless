package school.faang.bjs250440;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class OrderProcessor {
    public static final int NUMBER_OPERATION_PAYMENTS = 1_000;
    public static final int BAD_ORDER = 2;
    private final AtomicInteger totalProcessedOrders = new AtomicInteger(0);

    public int processAllOrders(@NonNull List<Order> orders) {
        orders.stream()
                .map(this::processOrder)
                .forEach(CompletableFuture::join);
        return totalProcessedOrders.get();
    }

    private CompletableFuture<Void> processOrder(Order order) {
        return CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(NUMBER_OPERATION_PAYMENTS);
                if (order.getId() % BAD_ORDER == 0) {
                    order.setStatus(OrderStatus.CANCELED);
                    System.out.println("Order id = " + totalProcessedOrders.intValue() + ", was cancel!");
                }
                order.setStatus(OrderStatus.PROCESSED);
                totalProcessedOrders.incrementAndGet();
            } catch (InterruptedException ex) {
                log.error("The task has been aborted!{}", String.valueOf(ex));
                Thread.currentThread().interrupt();
                throw new RuntimeException(ex);
            }
        });
    }
}
