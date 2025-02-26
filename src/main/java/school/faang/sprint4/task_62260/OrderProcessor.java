package school.faang.sprint4.task_62260;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class OrderProcessor {
    private static final int TIME_PROCESS_SEC = 2;
    private final AtomicInteger totalProcessedOrder = new AtomicInteger();

    public void processOrder(Order order) {
        try {
            order.setStatus(Status.IN_PROGRESS);
            log.debug("Start order progress {}", order);
            TimeUnit.SECONDS.sleep(TIME_PROCESS_SEC);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("Thread {} is interrupted", Thread.currentThread());
        }

        int count = totalProcessedOrder.incrementAndGet();
        order.setStatus(Status.PROCESSED);
        log.debug("Completed order {}, All complited orders {}", order, count);
    }

    public int getTotalProcessedOrders() {
        return totalProcessedOrder.get();
    }
}
