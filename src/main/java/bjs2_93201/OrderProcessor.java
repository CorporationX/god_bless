package bjs2_93201;

import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

class OrderProcessor {
    private static final int MIN_PROCESS_TIME = 2000;
    private static final int MAX_PROCESS_TIME = 5000;
    private static final double CANCEL_PROBABILITY = 0.65;
    private static final Random random = new Random();
    private final AtomicInteger totalProcessedOrders = new AtomicInteger(0);

    public CompletableFuture<Void> processOrder(Order order) {
        return CompletableFuture.runAsync(() -> {
            try {
                System.out.printf("Заказ %d: обработка началась...%n", order.getId());

                int delay = random.nextInt(MAX_PROCESS_TIME - MIN_PROCESS_TIME + 1) + MIN_PROCESS_TIME;
                Thread.sleep(delay);

                if (random.nextDouble() < CANCEL_PROBABILITY) {
                    order.setStatus(OrderStatus.PROCESSED);
                    totalProcessedOrders.incrementAndGet();
                    System.out.printf("Заказ %d: обработан (время: %d мс)%n", order.getId(), delay);
                } else {
                    order.setStatus(OrderStatus.CANCELED);
                    System.out.printf("Заказ %d: отменён (время: %d мс)%n", order.getId(), delay);
                }

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException("Ошибка при обработке заказа " + order.getId(), e);
            }
        });
    }

    public void processAllOrders(List<Order> orders) {
        List<CompletableFuture<Void>> futures = orders.stream()
                .map(this::processOrder)
                .toList();

        CompletableFuture<Void> all = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));

        all.join();

        System.out.println("\nОбработано успешно заказов: " + totalProcessedOrders.get());
    }
}