package faang.school.godbless.sprint3.ordersInAmazon;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class Main {

    private static final AtomicInteger ORDERS_COUNT = new AtomicInteger(0);

    public static void main(String[] args) {

        ExecutorService executorService = OrderExecutorServiceConfig.getExecutorService();

        OrderProcessor orderProcessor = new OrderProcessor(ORDERS_COUNT, executorService);

        Order order1 = new Order(1, OrderStatus.IN_PROCESS);
        Order order2 = new Order(2, OrderStatus.DONE);
        Order order3 = new Order(3, OrderStatus.CREATED);
        Order order4 = new Order(4, OrderStatus.CREATED);
        Order order5 = new Order(5, OrderStatus.CREATED);

        CompletableFuture<Void> future1 = orderProcessor.processOrder(order1);
        CompletableFuture<Void> future2 = orderProcessor.processOrder(order2);
        CompletableFuture<Void> future3 = orderProcessor.processOrder(order3);
        CompletableFuture<Void> future4 = orderProcessor.processOrder(order4);
        CompletableFuture<Void> future5 = orderProcessor.processOrder(order5);

        List<CompletableFuture<Void>> list = List.of(future1, future2, future3, future4, future5);

        CompletableFuture.allOf(list.toArray(new CompletableFuture[0]))
                .thenRun(() -> log.info("finally count: {}", orderProcessor.getTotalProcessedOrders()));

        executorService.shutdown();

        try {
            if (!executorService.awaitTermination(20L, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            } else {
                log.info("all executor tasks is done");
            }
        } catch (InterruptedException e) {
            log.error("{} is interrupted", Thread.currentThread().getName());
        }
    }
}
