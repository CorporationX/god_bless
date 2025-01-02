package derschrank.sprint04.task05.bjstwo_50135;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class OrderProcessor {
    private static final int DEFAULT_DELAY = 1000;
    private static final int MAX_MULTIPLICATOR_FOR_DELAY = 10;
    private final Random rnd;
    private final AtomicInteger totalProcessedOrders;

    public OrderProcessor() {
        totalProcessedOrders = new AtomicInteger(0);
        rnd = new Random();
    }

    public CompletableFuture<Void> processOrder(Order order) {
        return CompletableFuture.runAsync(
                () -> {
                    System.out.println(" + Order #" + order.getId() + " on processing...");
                    toSleepWithRandom(DEFAULT_DELAY);
                    order.changeStatus(Status.PROCESSED);
                    int count = totalProcessedOrders.incrementAndGet();
                    System.out.println(" - Order #" + order.getId() + " was processed. Total: " + count);
                }
        );
    }

    public int processAllOrders(List<Order> orders) {
        orders.stream()
                .map(this::processOrder)
                .toList()
                .forEach(CompletableFuture::join);

        return totalProcessedOrders.get();
    }



    private void toSleepWithRandom(int delay) {
        toSleep(delay * (1 + rnd.nextInt(MAX_MULTIPLICATOR_FOR_DELAY)));
    }

    private void toSleep(int delay) {
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            log.error("OrderProcessor was interrupted: " + e);
        }
    }

}
