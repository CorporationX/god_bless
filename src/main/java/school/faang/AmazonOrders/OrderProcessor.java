package school.faang.AmazonOrders;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class OrderProcessor {
    private final AtomicInteger totalProcessedOrders = new AtomicInteger(0);

    private void processOrder(Order order) {
        order.setStatus(OrderStatus.PENDING);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            log.error("Something went wrong", e);
            order.setStatus(OrderStatus.FAILED);
            return;
        }
        order.setStatus(OrderStatus.DONE);
        totalProcessedOrders.getAndIncrement();
        log.info("Order processed: {}", order.getId());
    }

    public void processAllOrders(List<Order> orders) {
        List<CompletableFuture<Void>> futures = new ArrayList<>();
        orders.forEach(order -> futures.add(CompletableFuture.runAsync(()-> processOrder(order))));

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]))
                .thenRun(() -> log.info("Totally orders processed: {}", totalProcessedOrders)).join();

    }
}
