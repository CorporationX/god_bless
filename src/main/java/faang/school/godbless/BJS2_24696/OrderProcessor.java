package faang.school.godbless.BJS2_24696;

import lombok.Getter;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
@Getter
public class OrderProcessor {
    private final AtomicInteger totalProcessedOrders = new AtomicInteger(0);

    @SneakyThrows
    public CompletableFuture<Integer> processOrder(Order order) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
                order.markDone();
                totalProcessedOrders.incrementAndGet();
            } catch (Exception exception) {
                log.error(exception.getMessage(), exception);
            }
            return totalProcessedOrders.get();
        });
    }
}
