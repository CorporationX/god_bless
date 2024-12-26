package school.faang.sprint_4.task_bjs250382;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
@RequiredArgsConstructor
public class OrderProcessor {
    private static final long WORK_EMULATE_TIME = 2000L;
    @Getter
    private final AtomicInteger totalProcessedOrders = new AtomicInteger(0);
    private final ExecutorService executor;

    public CompletableFuture<Void> processOrder(Order order) {
        return CompletableFuture.runAsync(() -> {
            emulateWork();
            order.setType(OrderType.COMPLETED);
            totalProcessedOrders.incrementAndGet();
            log.info("Order id {} was processed", order.getId());
        }, executor);
    }

    private static void emulateWork() {
        try {
            Thread.sleep(WORK_EMULATE_TIME);
        } catch (InterruptedException e) {
            log.warn("Thread was Interrupted");
            Thread.currentThread().interrupt();
        }
    }
}
