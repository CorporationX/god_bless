package faang.school.multithreadingparallelismthread.collectingordersinamazon;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

import static java.lang.Thread.currentThread;
import static java.lang.Thread.sleep;

@Slf4j
public class OrderProcessor {
    private final AtomicInteger totalProcessedOrders = new AtomicInteger();

    private static final long TIME_SLEEP_THREAD = 3000;

    public CompletableFuture<Void> processOrder(Order order) {
        log.info("processOrder start - Thread name {}", currentThread().getName());
        return CompletableFuture.runAsync(() -> {
            try {
                sleep(TIME_SLEEP_THREAD);

                order.setStatus(true);

                totalProcessedOrders.incrementAndGet();

            } catch (InterruptedException e) {
                log.error("Gathering ingredients interrupted", e);
                e.printStackTrace();
                currentThread().interrupt();
            }
            log.info("The processing procedure is finished. Order № {} thread name {}",
                    totalProcessedOrders.get(), currentThread().getName());
        });
    }
}
