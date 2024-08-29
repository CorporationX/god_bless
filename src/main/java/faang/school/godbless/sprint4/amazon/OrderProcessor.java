package faang.school.godbless.sprint4.amazon;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class OrderProcessor {
    private static final int QUANTITY_ORDERS = 10_000;
    private static final Random random = new Random();
    private static final AtomicInteger totalProcessedOrders = new AtomicInteger(0);
    private static final ExecutorService executor = Executors.newFixedThreadPool(QUANTITY_ORDERS);

    private static final List<Order> orders = new ArrayList<>(QUANTITY_ORDERS);
    private static final List<CompletableFuture<Integer>> orderFutures = new ArrayList<>(QUANTITY_ORDERS);

    public static void main(String[] args) {
        createOrders();
        createOrderFutures();
        countTotalProcessedOrders();
        executor.shutdown();
        System.out.printf("Общее количество отработанных заказов: %s%n", totalProcessedOrders);
    }

    private static CompletableFuture<Integer> processOrder(Order order) {
        return CompletableFuture
                .supplyAsync(() -> {
                    try {
                        Thread.sleep(random.nextInt(1, 11) * 1000L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    order.setStatus("Отработано");
                    return 1;
                }, executor);
    }

    private static void createOrders() {
        IntStream.rangeClosed(1, QUANTITY_ORDERS)
                .mapToObj(Order::new)
                .forEach(orders::add);
    }

    private static void countTotalProcessedOrders() {
        CompletableFuture
                .allOf(orderFutures.toArray(CompletableFuture[]::new))
                .thenRun(() -> orderFutures
                        .forEach(future -> totalProcessedOrders.addAndGet(future.join())))
                .join();
    }

    private static void createOrderFutures() {
        orders.stream()
                .map(OrderProcessor::processOrder)
                .forEach(orderFutures::add);
    }
}
