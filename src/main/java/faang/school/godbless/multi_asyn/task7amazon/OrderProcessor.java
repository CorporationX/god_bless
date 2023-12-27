package faang.school.godbless.multi_asyn.task7amazon;

import lombok.Getter;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

@Getter
public class OrderProcessor {
    private final AtomicInteger totalProcessedOrders = new AtomicInteger();
    ExecutorService executor = Executors.newCachedThreadPool();

    public CompletableFuture<Void> processOrder(Order order) {
        return CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            order.setStatus("Обработано");
            totalProcessedOrders.addAndGet(1);
        }, executor);
    }

    public void endProcess() {
        executor.shutdown();
    }
}
