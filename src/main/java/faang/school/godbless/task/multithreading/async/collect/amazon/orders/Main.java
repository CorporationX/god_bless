package faang.school.godbless.task.multithreading.async.collect.amazon.orders;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.LongStream;

@Slf4j
public class Main {
    private static final int NUMBER_OF_ORDERS = 10;
    private static final int THREAD_POOL_SIZE = NUMBER_OF_ORDERS;

    private static final OrderProcessor orderProcessor = new OrderProcessor(THREAD_POOL_SIZE);
    private static final List<CompletableFuture<Void>> futures = new ArrayList<>();
    private static List<Order> orders;

    public static void main(String[] args) {
        orders = getOrders();
        futures.addAll(runTask());
        printResult();
        orderProcessor.executorShutdown();
    }

    private static List<CompletableFuture<Void>> runTask() {
        return orders
                .stream()
                .map(orderProcessor::processOrder)
                .toList();
    }

    private static void printResult() {
        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]))
                .thenRun(() -> log.info("Total processed orders: {}", orderProcessor.getTotalProcessedOrders()));
    }

    private static List<Order> getOrders() {
        return LongStream
                .rangeClosed(1, NUMBER_OF_ORDERS)
                .mapToObj(Order::new)
                .toList();
    }
}
