package faang.school.godbless.FourthSprint.bjs2_50335;

import java.lang.reflect.Array;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class OrderProcessor {
    private static final long SLEEP_TIME = 1000L;
    private final AtomicInteger totalProcessedOrders = new AtomicInteger(0);

    public CompletableFuture<Void> processOrder(Order order) {
        return CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(SLEEP_TIME);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            order.setStatus(Status.PROCESSED);
            totalProcessedOrders.incrementAndGet();
        });
    }

    public void processAllOrders(List<Order> orders) {
        List<CompletableFuture<Void>> processed = orders.stream()
                .map(order -> processOrder(order))
                .collect(Collectors.toList());
        CompletableFuture.allOf(processed.toArray(new CompletableFuture[0]))
                .thenRun(() -> System.out.println("Всего заказов было обработано: " + totalProcessedOrders.get()))
                .join();
    }
}
