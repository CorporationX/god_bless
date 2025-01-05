package school.faang.sprint_4.task_50217;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicInteger;

public class OrderProcessor {
    private final AtomicInteger totalProcessesOrders = new AtomicInteger(0);

    public void processAllOrders(List<Order> orders) throws ExecutionException, InterruptedException {
        List<CompletableFuture<Void>> futures = orders.stream()
                .map(this::processOrder)
                .toList();

        CompletableFuture<Void> all = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));
        all.get();

        System.out.println("Обработано заказов: " + totalProcessesOrders);
    }

    private CompletableFuture<Void> processOrder(Order order) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(3000);
                order.changeStatus();
                totalProcessesOrders.getAndIncrement();
            } catch (InterruptedException e) {
                System.out.println("Поток " + Thread.currentThread().getName() + " прервал работу");
            }
            return null;
        });
    }
}
