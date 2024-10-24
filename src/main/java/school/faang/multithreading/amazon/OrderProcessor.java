package school.faang.multithreading.amazon;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class OrderProcessor {
    private final AtomicInteger totalProcessedOrders = new AtomicInteger(0);

    private CompletableFuture<Void> processOrder(Order order, ExecutorService executor) {
        return CompletableFuture.runAsync(() -> {
            try {
                System.out.println("Заказ: " + order.getId() + " принят в обработку");
                Thread.sleep(3000);
                order.setStatus("Обработано");
                totalProcessedOrders.incrementAndGet();
                System.out.println("Заказ: " + order.getId() + " обработан");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, executor);
    }

    public void processAllOrders(List<Order> orders) {
        ExecutorService executor = Executors.newCachedThreadPool();
        List<CompletableFuture<Void>> futures = orders.stream()
                .map(order -> processOrder(order, executor))
                .toList();
        futures.forEach(CompletableFuture::join);
        executor.shutdown();
        System.out.println("Все заказы обработаны. Общее количество заказов: " + totalProcessedOrders.get());
    }
}
