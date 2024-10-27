package school.faang.sprint4.amazon;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

public class OrderProcessor {
    private final AtomicInteger atomicCounter = new AtomicInteger(0);

    public void processAllOrders(List<Order> orders) {

        List<CompletableFuture<Void>> futures = orders.stream()
                .map(order -> CompletableFuture.runAsync(() -> {
                    try {
                        Thread.sleep(3000);
                        atomicCounter.incrementAndGet();
                    } catch (InterruptedException e) {
                        System.out.println("Invalid async");
                    }
                })).toList();

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]))
                .thenRun(() -> System.out.println("Обработано заказов: " + atomicCounter.get()));

    }
}
