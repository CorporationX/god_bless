package school.faang.amazon;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@NoArgsConstructor
@Getter
public class OrderProcessor {
    private final AtomicInteger totalProcessedOrders = new AtomicInteger(0);

    public List<CompletableFuture<Void>> processAllOrders(List<Order> orders) {
        return orders.stream()
                .map(this::processOrder)
                .collect(Collectors.toList());
    }

    public CompletableFuture<Void> processOrder(Order order) {
        return CompletableFuture.runAsync(() -> {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    order.setStatus("PROCESSED");
                    this.totalProcessedOrders.incrementAndGet();
                }
        );
    }
}
