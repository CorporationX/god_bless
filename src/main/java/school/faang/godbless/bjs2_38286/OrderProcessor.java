package school.faang.godbless.bjs2_38286;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class OrderProcessor {
    private static final int OPERATION_TIME = 3000;
    private static final int NUMBER_OF_THREADS = 8;

    private final AtomicInteger totalProcessedOrders = new AtomicInteger();

    private void processOrder(@NonNull Order order) {
        try {
            if (ThreadLocalRandom.current().nextDouble(0, 1) < 0.3) {
                throw new InterruptedException("Random interrupt");
            }
            if (order.getStatus() != Order.Status.NEW) {
                log.error("Can process only orders that have status NEW. Failed to process order {}", order);
                order.setStatus(Order.Status.ERROR);
            } else {
                Thread.sleep(OPERATION_TIME);
                order.setStatus(Order.Status.PROCESSED);
                totalProcessedOrders.incrementAndGet();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            order.setStatus(Order.Status.ERROR);
            log.error("Thread {} interrupted when processing order {}", Thread.currentThread().getName(), order);
        }
    }

    public void processAllOrders(List<Order> orders) {
        ExecutorService pool = Executors.newFixedThreadPool(NUMBER_OF_THREADS);
        List<CompletableFuture<Void>> futures = orders.stream()
                .map(order -> CompletableFuture.runAsync(() -> processOrder(order), pool)).toList();
        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();
        pool.shutdown();
        log.info("Total processed orders: {}", totalProcessedOrders.get());
        log.error("Failed to process orders: {}", orders.stream().filter(order -> order.getStatus() != Order.Status.PROCESSED).toList());
    }
}
