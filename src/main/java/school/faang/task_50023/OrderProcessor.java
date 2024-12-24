package school.faang.task_50023;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;


public class OrderProcessor {
    public AtomicInteger totalProcessedOrders = new AtomicInteger(0);
    ExecutorService executor = Executors.newCachedThreadPool();

    public CompletableFuture<Void> processOrder(Order order) {
        CompletableFuture<Void> futureOrder = CompletableFuture.runAsync(() -> {
                    try {
                        Thread.currentThread().sleep(2000);
                        order.setStatus("обработан");
                        totalProcessedOrders.getAndIncrement();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }, executor)
                .thenRun(() -> System.out.println("Заказ " + order.getId()
                        + " был успешно обработан и переведен в статус: " + order.getStatus()));
        return futureOrder;
    }
    public void processAllOrders(List<Order> orders) {
        List<CompletableFuture<Void>> allOrdersProcessed = orders.stream()
                .map(order -> processOrder(order))
                .collect(Collectors.toList());
        CompletableFuture<Void> result = CompletableFuture.allOf(allOrdersProcessed.toArray(new CompletableFuture[0]))
                .thenRun(() -> System.out.println("Всего заказов было обработано: " + totalProcessedOrders.get()));
    }

    public void shutdownExecutor() {
        executor.shutdown();
    }

}
