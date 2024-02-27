package faang.school.godbless.collectingamazonorders3165;

import lombok.Getter;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicInteger;

public class OrderProcessor {
    @Getter private AtomicInteger totalProcessedOrders = new AtomicInteger(0);
    private static final Random RANDOM = new Random();

    public CompletableFuture<Void> processOrder(Order order, ExecutorService executor) {
        return CompletableFuture.runAsync(() -> {
            System.out.printf("%s order #%d...%n", order.getStatus(), order.getId());
            threadSleep(RANDOM.nextLong(75L, 125L));
            totalProcessedOrders.incrementAndGet();
            order.setStatus("Done.");
            System.out.printf("Order #%d is %s%n", order.getId(), order.getStatus());
        }, executor);
    }

    private static void threadSleep(long timeInMillis) {
        try {
            Thread.sleep(timeInMillis);
        } catch (InterruptedException e) {
            System.out.println("Thread was interrupted");
            Thread.currentThread().interrupt();
        }
    }
}
