package faang.school.godbless.task.multithreading.async.collect.amazon.orders;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
@Getter
public class OrderProcessor {
    private static final int PROCESS_TIME_MAX = 5000;
    private static final int PROCESS_TIME_MIN = 2000;

    private final AtomicInteger totalProcessedOrders = new AtomicInteger();
    private final Random random = new Random();
    private final ExecutorService executor;

    public OrderProcessor(int threadPoolSize) {
        executor = Executors.newFixedThreadPool(threadPoolSize);
    }

    public CompletableFuture<Void> processOrder(Order order) {
        return CompletableFuture.runAsync(() -> process(order), executor);
    }

    private void process(Order order) {
        log.info("Order id: {}, accepted for processing", order.getId());
        sleep();
        order.statusProcessed();
        totalProcessedOrders.incrementAndGet();
    }

    private void sleep() {
        int processTime = random.nextInt(PROCESS_TIME_MAX - PROCESS_TIME_MIN) + PROCESS_TIME_MIN;
        try {
            Thread.sleep(processTime);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void executorShutdown() {
        executor.shutdown();
    }
}
