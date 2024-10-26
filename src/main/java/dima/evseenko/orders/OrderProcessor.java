package dima.evseenko.orders;

import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class OrderProcessor {
    private final AtomicInteger totalProcessedOrders = new AtomicInteger(0);

    private ExecutorService executor = Executors.newCachedThreadPool();

    public Order processOrder(Order order) {
        try {
            order.setStatus(Status.PROCESSING);
            Thread.sleep(new Random().nextInt(5000 - 1000) + 1000);
            order.setStatus(Status.COMPLETED);
            totalProcessedOrders.set(totalProcessedOrders.get() + 1);
            return order;
        } catch (InterruptedException e) {
            order.setStatus(Status.FAILED);
            e.printStackTrace();
            throw new IllegalStateException("Ошибка обработки заказа номер%s".formatted(order.getId()), e);
        }
    }

    public void processAllOrders(List<Order> orders) {
        if (executor.isShutdown()) {
            executor = Executors.newCachedThreadPool();
        }

        List<CompletableFuture<Order>> futures = orders.stream().map(order -> CompletableFuture.supplyAsync(() -> processOrder(order), executor)).toList();

        executor.shutdown();

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).thenAccept((Void aVoid) -> {
            System.out.printf("Обработано заказов: %s%n", totalProcessedOrders.get());
        });
    }
}
