package faang.school.godbless.sprint5.multithreading_async.task10_amazon;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

public class OrderProcessor {

    private static final AtomicInteger totalProcessedOrders = new AtomicInteger();

    public CompletableFuture<Void> processOrder(Order order) {
        return CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            order.setStatus("Обработано");
            totalProcessedOrders.getAndIncrement();
        });
    }

    public static void main(String[] args) {
        OrderProcessor orderProcessor = new OrderProcessor();
        List<Order> orders = getOrders();

        List<CompletableFuture<Void>> completableFutureList = orders.stream()
                .map(orderProcessor::processOrder)
                .toList();

        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.allOf(completableFutureList.toArray(new CompletableFuture[orders.size()]));

        voidCompletableFuture.thenRun(() -> {}).join();

        System.out.println("Всего обработано заказов: " + totalProcessedOrders.get());

    }

    private static List<Order> getOrders() {
        List<Order> orders = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            orders.add(new Order(i));
        }
        return orders;
    }
}