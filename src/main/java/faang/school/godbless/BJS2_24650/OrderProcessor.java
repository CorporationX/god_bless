package faang.school.godbless.BJS2_24650;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
@Getter
public class OrderProcessor {
    private static final int WAIT_MULTIPLIER = 1000;
    private AtomicInteger totalProcessedOrders;
    private ExecutorService executorService;

    public OrderProcessor(ExecutorService executorService) {
        totalProcessedOrders = new AtomicInteger(0);
        this.executorService = executorService;
    }

    public CompletableFuture<Void> processOrder(Order order){
        return CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(WAIT_MULTIPLIER * order.getId());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                log.error("Thread error: {}", e.getMessage());
            }
            order.setStatus(STATUS.PROCESSED);
            totalProcessedOrders.incrementAndGet();
            log.info("Processed orders: {}", totalProcessedOrders);
        }, executorService);
    }

    public void shutdown(){
        executorService.shutdown();
    }
}
