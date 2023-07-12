package faang.school.godbless.collectingOrdersAmazon;

import lombok.Getter;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

@Getter
public class OrderProcessor {
    private final AtomicInteger totalProcessedOrders = new AtomicInteger(0);

    public CompletableFuture<Void> processOrder(Order order) {
        System.out.println("Обрабатывается заказ Id" + order.getId());

        return CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            order.setStatus("Обработано");

            totalProcessedOrders.incrementAndGet();
            System.out.println("Заказ Id" + order.getId() + " обработан. Новый статус: " + order.getStatus());

        });
    }

}
