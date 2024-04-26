package faang.school.godbless.async.task_7.processors;

import faang.school.godbless.async.task_7.model.Order;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class OrderProcessor {
    private static final long SLEEPING_TIME = 5000;
    private final AtomicInteger totalProcessedOrders = new AtomicInteger(0);

    public CompletableFuture<Integer> processOrder(Order order, Executor pool) {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("начинается обработка заказа " + order.getId());
            try {
                Thread.sleep(SLEEPING_TIME);
            } catch (InterruptedException e) {
                log.error(e.getMessage());
                e.printStackTrace();
            }
            order.processed();
            System.out.println("заказ " + order.getId() +  " обработан");
            return totalProcessedOrders.incrementAndGet();
        }, pool);
    }

    public int getTotalProcessedOrders() {
        return totalProcessedOrders.get();
    }
}