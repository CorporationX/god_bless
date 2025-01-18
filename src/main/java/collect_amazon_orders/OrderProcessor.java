package collect_amazon_orders;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@Getter
@Setter
@Slf4j
public class OrderProcessor {
    private AtomicInteger totalProcessedOrders = new AtomicInteger(0);

    public CompletableFuture<Order> processOrder(Order order, ExecutorService executorService) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                throw new RuntimeException("Операция прервана!");
            }
            order.setStatus("Обработано");
            totalProcessedOrders.incrementAndGet();
            log.info("{} Промежуточная аналитика: {}", Thread.currentThread(),totalProcessedOrders.get());
            return order;
        }, executorService);
    }
}