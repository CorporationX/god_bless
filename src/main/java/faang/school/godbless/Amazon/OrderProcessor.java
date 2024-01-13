package faang.school.godbless.Amazon;

import lombok.Getter;

import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

@Getter
public class OrderProcessor {
    private static final AtomicInteger totalProcessedOrders = new AtomicInteger(0);
    private static final Random random = new Random();
    // почему final не понял, идея просит
    public static CompletableFuture<AtomicInteger> processOrder(Order order) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println("Processing order " + order.getId() + " with status " + order.getStatus());
                Thread.sleep(random.nextInt(10000));
                order.setStatus("Processed");
                System.out.println("Processed order " + order.getId() + " with status " + order.getStatus());
                totalProcessedOrders.incrementAndGet();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return totalProcessedOrders;// не понял почему,но почему-то нельзя тут же инкрементацию сделать, иначе будет просить
            // изменить тип возвращаемого значения методом на CompletableFuture<Integer>
        });
    }

    public static void main(String[] args) {
        List<Order> orders = List.of(
                new Order(getRandomId(), "Pending"),
                new Order(getRandomId(), "Pending"),
                new Order(getRandomId(), "Pending"),
                new Order(getRandomId(), "Pending"),
                new Order(getRandomId(), "Pending"),
                new Order(getRandomId(), "Pending")
        );
        CompletableFuture<Void> future = CompletableFuture.allOf(orders.stream().map(OrderProcessor::processOrder).toArray(CompletableFuture[]::new));
        future.join();
        System.out.println("Number of processed orders: " + totalProcessedOrders);// думал, нужен get обязательно, что бы получить int,
        // но с join тоже работает и обработку исключения не надо прописывать
    }

    private static String getRandomId() {
        return UUID.randomUUID().toString();
    }
}
