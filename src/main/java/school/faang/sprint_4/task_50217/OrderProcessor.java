package school.faang.sprint_4.task_50217;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class OrderProcessor {
    private final AtomicInteger totalProcessesOrders = new AtomicInteger(0);

    public void processAllOrders(List<Order> orders) {
        List<CompletableFuture<Void>> futures = orders.stream()
                .map(this::processOrder)
                .toList();

        CompletableFuture<Void> all = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));

        try {
            all.get();
        } catch (InterruptedException | ExecutionException e) {
            log.error("Один из потоков прервал работу");
        }

        System.out.println("Обработано заказов: " + totalProcessesOrders);
    }

    private CompletableFuture<Void> processOrder(Order order) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(3000);
                order.setProcessedStatus();
                totalProcessesOrders.getAndIncrement();
            } catch (InterruptedException e) {
                System.out.println("Поток " + Thread.currentThread().getName() + " прервал работу");
            }
            return null;
        });
    }
}
