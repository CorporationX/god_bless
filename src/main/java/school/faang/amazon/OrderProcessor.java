package school.faang.amazon;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

import static school.faang.amazon.OrderStatus.CANCELED;
import static school.faang.amazon.OrderStatus.PROCESSED;

public class OrderProcessor {
    private static final int THREAD_SLEEP_TIME = 3000;
    private static final Logger log = LoggerFactory.getLogger(OrderProcessor.class);
    private final AtomicInteger totalProcessedOrders;

    public OrderProcessor() {
        this.totalProcessedOrders = new AtomicInteger(0);
    }

    public CompletableFuture<Void> processOrder(Order order) {
        return CompletableFuture.runAsync(() -> {
            threadSleep();
            if (order.getStatus() != CANCELED) {
                order.setStatus(PROCESSED);
                totalProcessedOrders.incrementAndGet();
            }
        });
    }

    public void processAllOrders(List<Order> orders) {
        List<CompletableFuture<Void>> futers = orders.stream()
                .map(this::processOrder)
                .toList();

        CompletableFuture<Void> allOf =
                CompletableFuture.allOf(futers.toArray(new CompletableFuture[0]));

        allOf.thenRun(() -> {
            log.info("Обработано заказов: {}", totalProcessedOrders.get());
        }).join();
    }

    public void threadSleep() {
        try {
            Thread.sleep(THREAD_SLEEP_TIME);
        } catch (InterruptedException e) {
            log.error("Thread was interrupted {}", e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
