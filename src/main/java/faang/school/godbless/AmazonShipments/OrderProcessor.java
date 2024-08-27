package faang.school.godbless.AmazonShipments;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

@Getter
@Setter
@AllArgsConstructor
public class OrderProcessor {
    private final AtomicInteger totalProcessedOrders = new AtomicInteger(0);

    public CompletableFuture<Void> processOrder(Order order) {
        return CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(800);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            order.setStatus("Обработано");
            totalProcessedOrders.incrementAndGet();
            System.out.println("Order " + order.getId() + " processed. Total processed orders: " + totalProcessedOrders.get());
        });
    }

    public static void main(String[] args) {
        OrderProcessor processor = new OrderProcessor();

        Order order1 = new Order(1, "New");
        Order order2 = new Order(2, "New");
        Order order3 = new Order(3, "New");

        CompletableFuture<Void> result1 = processor.processOrder(order1);
        CompletableFuture<Void> result2 = processor.processOrder(order2);
        CompletableFuture<Void> result3 = processor.processOrder(order3);
        List<CompletableFuture<Void>> allFutures = List.of(result1, result2, result3);

        CompletableFuture<Void> allOrders = CompletableFuture.allOf(allFutures.toArray(new CompletableFuture[0]))
                .thenRun(() -> System.out.println("Общее количество заказов: " + processor.getTotalProcessedOrders()));
        allOrders.join();
    }
}
