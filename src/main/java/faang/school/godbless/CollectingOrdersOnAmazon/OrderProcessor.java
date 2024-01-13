package faang.school.godbless.CollectingOrdersOnAmazon;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

public class OrderProcessor {
    // не поняла... что, не нужно создавать каждый раз потоки ExecutorService?
    // через CompletableFuture и так создаются разные потоки...
    // или у меня остались не закрытые потоки?
    public AtomicInteger totalProcessedOrders = new AtomicInteger();

    public CompletableFuture<Void> processOrder(Order order) {
        return CompletableFuture.runAsync(() -> {
            try {
                System.out.println("Обработка заказа " + order.getId() + " в потоке " + Thread.currentThread().getName());
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Обработка прервана");
            }
            order.setStatus("Обработано");
            System.out.println("Статус заказа " + order.getId() + ": " + order.getStatus());
            totalProcessedOrders.incrementAndGet();
        });
    }

    public static void main(String[] args) {
        OrderProcessor orderProcessor = new OrderProcessor();

        List<Order> orders = new ArrayList<>(List.of(
                new Order(1, "Получено"),
                new Order(2, "В обработке"),
                new Order(3, "Отправляется"),
                new Order(4, "Получено")));

        CompletableFuture[] process = orders.stream()
                .map(orderProcessor::processOrder)
                .toArray(CompletableFuture[]::new);

        CompletableFuture.allOf(process).join();

        System.out.println("Заказы обработаны: " + orderProcessor.totalProcessedOrders.get());
    }
}
