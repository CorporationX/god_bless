package school.faang.bjs250440;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class OrderProcessor {
    public static final int TIME_FOR_ONE_OPERATION = 1_000;
    public static final int TYPE_OF_ORDERS_TO_CANCEL = 2;
    private final AtomicInteger totalProcessedOrders = new AtomicInteger(0);

    public int processAllOrders(@NonNull List<Order> orders) {

        List<CompletableFuture<Void>> futuresList = new ArrayList<>();
        orders.forEach(order -> futuresList.add(processOrder(order)));

        CompletableFuture<?>[] futuresArray = futuresList.toArray(new CompletableFuture[0]);
        CompletableFuture<Void> allTasks = CompletableFuture.allOf(futuresArray);

        allTasks.thenRun(() -> System.out.println("All orders are processed!"));
        allTasks.join();

        return totalProcessedOrders.get();
    }

    private CompletableFuture<Void> processOrder(Order order) {
        return CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(TIME_FOR_ONE_OPERATION);
                if (order.getId() % TYPE_OF_ORDERS_TO_CANCEL == 0) {
                    order.setStatus(OrderStatus.CANCELED);
                    System.out.println("Order id = " + totalProcessedOrders.intValue() + ", was cancel!");
                } else {
                    order.setStatus(OrderStatus.PROCESSED);
                }
                totalProcessedOrders.incrementAndGet();
            } catch (InterruptedException ex) {
                log.error("The task has been aborted!{}", String.valueOf(ex));
                Thread.currentThread().interrupt();
                throw new RuntimeException(ex);
            }
        });
    }
}
