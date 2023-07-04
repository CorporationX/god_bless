package Sprint_4_1_Task10;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

@Data
public class OrderProcessor {
    private int sum = 0;
    AtomicInteger totalProcessedOrders = new AtomicInteger(sum);

    private CompletableFuture<Void> processOrder(Order order) {
        return CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Order " + order.getId() + " processed");
            totalProcessedOrders.incrementAndGet();
        });
    }

    public static void main(String[] args) {
        OrderProcessor processor = new OrderProcessor();
        List<CompletableFuture<Void>> orders = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            Order order = new Order(i, "processing");
            orders.add(processor.processOrder(order));
        }
        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.allOf(orders.toArray(new CompletableFuture[0]));
        voidCompletableFuture.thenAccept((x) -> {
            System.out.println("Total processed orders: " + processor.totalProcessedOrders);
        });
        voidCompletableFuture.join();

    }
}
