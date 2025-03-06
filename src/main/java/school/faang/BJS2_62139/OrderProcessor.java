package school.faang.BJS2_62139;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

public class OrderProcessor {
    private final AtomicInteger totalProcessedOrders = new AtomicInteger(0);

    private CompletableFuture<Integer> processOrder(Order order) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(100);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            order.setStatus("Обработано");
            return totalProcessedOrders.addAndGet(1);
        });
    }

    public void processAllOrders(List<Order> orders) {
        List<CompletableFuture<Integer>> future = orders.stream()
                .map(this::processOrder)
                .toList();
        CompletableFuture.allOf(future.toArray(new CompletableFuture[future.size()])).join();
        System.out.printf("Обработано заказов: %d\n", totalProcessedOrders.get());
    }
}
