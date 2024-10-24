package school.faang.amazon;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

@Data
@AllArgsConstructor
@Slf4j
public class OrderProcessor {
    private static final ExecutorService THREAD_POOL = Executors.newFixedThreadPool(5);
    private static final Integer SLEEP_TIME = 5000;

    private AtomicInteger  totalProcessedOrders;

    public CompletableFuture<Void>  processOrder(Order order){
        return CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(SLEEP_TIME);
                order.setStatus(OrderStatus.DONE.getStatus());
                System.out.println("Заказ с ID " + order.getId() + " обработан.");
                totalProcessedOrders.incrementAndGet();
            } catch (InterruptedException e) {
                log.error(e.getMessage());
                throw new IllegalStateException("Ошибка в потоке" + e.getMessage());
            }
        });
    }
}
