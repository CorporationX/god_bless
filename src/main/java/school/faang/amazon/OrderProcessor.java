package school.faang.amazon;

import lombok.Data;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

@Data
public class OrderProcessor {
    private final Integer threadSleepDelay = 2000;
    private AtomicInteger totalProcessOrders = new AtomicInteger(0);

    public CompletableFuture<Void> processOrder(Order order) {
        return CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(threadSleepDelay);
                order.setStatus(OrderStatus.PROCESSED);
                totalProcessOrders.incrementAndGet();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new OrderInterruptedException("Ошибка при обработке заказа");
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
