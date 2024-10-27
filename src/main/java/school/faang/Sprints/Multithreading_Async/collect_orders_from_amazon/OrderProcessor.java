package school.faang.Sprints.Multithreading_Async.collect_orders_from_amazon;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class OrderProcessor {
    private AtomicInteger totalProcessedOrders = new AtomicInteger(0);

    private CompletableFuture<Void> processOrder(Order order, ExecutorService executor) {
        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(2_000);
                System.out.println(Thread.currentThread().getName());
                order.setStatus("Processed");
                totalProcessedOrders.addAndGet(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, executor);
        return future;
    }

    public void processAllOrders(List<Order> orders) {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        List<CompletableFuture<Void>> futures = orders.stream()
                .map(order -> processOrder(order, executor))
                .collect(Collectors.toList());

        CompletableFuture<Void> allFutures = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));

        allFutures.thenRun(() -> {
            System.out.println(totalProcessedOrders);
        }).join();
        executor.shutdown();
    }
}
