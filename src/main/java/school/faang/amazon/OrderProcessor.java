package school.faang.amazon;

import lombok.Data;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

@Data
public class OrderProcessor {
    private AtomicInteger totalProcessOrders = new AtomicInteger(0);

    public CompletableFuture<Void> processOrder(Order order) {
        return CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(2000);
                order.setStatus(OrderStatus.PROCESSED);
                totalProcessOrders.incrementAndGet();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
        });
    }

    public void processAllOrders(List<Order> orderList) {
        List<CompletableFuture<Void>> processOrders =
                orderList.stream()
                .map(this::processOrder)
                .toList();
        CompletableFuture.allOf(processOrders.toArray(new CompletableFuture[0])).join();
    }

}
