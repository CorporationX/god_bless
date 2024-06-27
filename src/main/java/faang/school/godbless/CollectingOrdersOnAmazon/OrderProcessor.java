package faang.school.godbless.CollectingOrdersOnAmazon;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

import static faang.school.godbless.CollectingOrdersOnAmazon.OrderStatus.*;

@Slf4j
public class OrderProcessor {
    private static final Random random = new Random();
    private final AtomicInteger totalProcessedOrders = new AtomicInteger(0);
    private static final int NUM_THREADS = 3;
    private static final ExecutorService EXECUTOR = Executors.newFixedThreadPool(NUM_THREADS);
    private final List<CompletableFuture<Void>> allOrdersFuture = new ArrayList<>();

    public void processOrder(Order order) {
        CompletableFuture<Void> orderFuture = CompletableFuture.runAsync(() -> {
            order.setStatus(PROCESSING);
            log.info(order.getId() + " status: " + order.getStatus());
        }).thenRun(() -> {
            try {
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            order.setStatus(PROCESSED);
            totalProcessedOrders.addAndGet(1);
            log.info(order.getId() + " status: " + order.getStatus());
        });
        synchronized (allOrdersFuture) {
            allOrdersFuture.add(orderFuture);
        }
    }

    public void waitingAllOrdersProcessed() {
        CompletableFuture<Void> allFutures = CompletableFuture.allOf(allOrdersFuture.toArray(new CompletableFuture[0]));
        allFutures.join();
    }

    public static void shutdownOrderProcessor() {
        EXECUTOR.shutdown();
    }
}
