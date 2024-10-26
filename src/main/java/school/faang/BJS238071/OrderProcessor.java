package school.faang.BJS238071;

import lombok.Data;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Data
public class OrderProcessor {
    private AtomicInteger totalProcessedOrders = new AtomicInteger();
    private long processTime = 5000;

    public void processAllOrders(List<Order> orders) {
        List<CompletableFuture<Void>> futures = orders.stream()
                .map(order -> processOrder(order))
                .collect(Collectors.toList());
        futures.forEach(future -> future.join());
        System.out.println("Обработано заказов: " + totalProcessedOrders.get());
    }

    public CompletableFuture<Void> processOrder(Order order) {
        return CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(processTime);
                order.setStatus(OrderStatus.PROCESSED);
                totalProcessedOrders.addAndGet(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }
}
