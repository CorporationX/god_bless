package school.faang.sprint4.task_62260;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class OrderProcessor {
    public static final ExecutorService EXECUTOR = Shop.getEXECUTOR();
    private final AtomicInteger totalProcessedOrder = new AtomicInteger();

    public void processOrder(Order order) {
        try {
            order.setStatus(Status.IN_PROGRESS);
            log.debug("Start order progress {}", order);
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
        int count = totalProcessedOrder.incrementAndGet();
        order.setStatus(Status.PROCESSED);
        log.debug("Completed order {}, All complited orders {}", order, count);
    }

    public int getTotalProcessedOrders() {
        return totalProcessedOrder.get();
    }
}
