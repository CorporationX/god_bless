package faang.school.godbless.multithreading_2.amazon;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

public class OrderProcessor {
    private static final int processingTime = 1000;
    private static final int NUM_ORDERS = 100;
    private static final AtomicInteger totalProcessedOrders = new AtomicInteger();

    public static void main(String[] args) {
        List<Order> orders = new ArrayList<>();
        for (int i = 0; i < NUM_ORDERS; i++) {
            orders.add(new Order(i));
        }

        List<CompletableFuture<Void>> orderFutures = orders.stream()
                .map(OrderProcessor::processOrder)
                .toList();

        CompletableFuture.allOf(orderFutures.toArray(new CompletableFuture[0])).join();
        System.out.println(totalProcessedOrders.get());
    }
    private static CompletableFuture<Void> processOrder(Order order) {
        return CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(processingTime);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            order.setStatus("Обработано");
            totalProcessedOrders.addAndGet(1);
        });
    }
}
