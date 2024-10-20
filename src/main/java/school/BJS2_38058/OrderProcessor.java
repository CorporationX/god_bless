package school.BJS2_38058;

import lombok.Getter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

@Getter
public class OrderProcessor {
    private AtomicInteger totalProcessedOrders = new AtomicInteger(0);

    public CompletableFuture<Void> processOrder(Order order) {
        return CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(5000);
                order.setStatus("Обработано!");
                totalProcessedOrders.incrementAndGet();
            } catch (InterruptedException e) {
                e.printStackTrace();
                throw new RuntimeException();
            }
        });
    }

    public void processAllOrders(List<Order> orders) {
        List<CompletableFuture<Void>> futures = new ArrayList<>();
        for (Order order : orders) {
            futures.add(processOrder(order));
        }
        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]))
                .thenRun(() -> System.out.println("Общее количество обработанных заказов: " + totalProcessedOrders.get()))
                .join();
    }
}
