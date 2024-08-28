package faang.school.godbless.BJS2_24810;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@Getter
@Setter
@ToString
public class OrderProcessor {
    private final AtomicInteger totalProcessedOrders = new AtomicInteger(0);

    public CompletableFuture<Void> processOrder(Order order) {
        return CompletableFuture.runAsync(() -> {
            try {
                System.out.println("Начали обрабатывать заказ: " + order.getId());

                TimeUnit.SECONDS.sleep(2);

                totalProcessedOrders.incrementAndGet();

                System.out.println("Заказ " + order.getId() + " был обработан.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }
}
