package faang.school.godbless.sprint4.amazon_orders;

import lombok.Getter;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

@Getter
public class OrderProcessor {
    private final AtomicInteger totalProcessed = new AtomicInteger(0);
    private final ExecutorService executor = Executors.newFixedThreadPool(100);

    public CompletableFuture<Void> processOrder(Order order) {
        return CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(250);
            } catch(InterruptedException e) {
                throw new RuntimeException("Thread interrupted!");
            }
            order.setStatus(Status.PROCESSED);
            totalProcessed.incrementAndGet();
        }, executor);
    }

    public void shutdownExecutor() {
        executor.shutdown();
    }
}
