package school.faang.collect.orders.amazon;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class OrderProcessor {
    private final AtomicInteger totalProcessedOrders =
            new AtomicInteger(0);

    public void processOrder(Order order) {
        try {
            System.out.println("Обрабатываем заказ");
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        order.setStatus("Обработано");
        totalProcessedOrders.addAndGet(1);
    }

    public void processAllOrders(List<Order> orders) {
        ExecutorService executor = Executors.newFixedThreadPool(orders.size());
        List<CompletableFuture<Void>> futures = orders.stream()
                .map(order -> CompletableFuture.runAsync(() -> processOrder(order), executor))
                .toList();
        CompletableFuture<Void> allTasks = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));
        allTasks.thenRun(() -> System.out.println("Кол-во обработанных заказов: " + totalProcessedOrders.get()))
                        .whenComplete((res, ex) -> executor.shutdown());
        allTasks.join();
    }
}
