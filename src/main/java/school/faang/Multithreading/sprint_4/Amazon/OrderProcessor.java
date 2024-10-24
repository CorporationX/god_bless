package school.faang.Multithreading.sprint_4.Amazon;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Vector;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class OrderProcessor {
    public final static long TIME_PROCESS = 3_000;
    private AtomicInteger totalProcessedOrders;

    public void processAllOrders (List<Order> orders){
        List<CompletableFuture<Void>> futures = orders.stream()
                .map(order -> processOrder(order)) // Асинхронная обработка каждого заказа
                .collect(Collectors.toList());


        CompletableFuture.allOf(futureTotalsList.toArray(CompletableFuture[0]));

        System.out.println("Обработано заказов: " + totalProcessedOrders);
    }

    private void processOrder(Order order){
        CompletableFuture<Void> futureOrder = CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(TIME_PROCESS);
                order.setStatus(OrderStatus.PROCESSED);
                totalProcessedOrders.incrementAndGet();
            } catch (InterruptedException e) {
                log.error("Операция была прервана", e);
                throw new RuntimeException(e);
            }
        });



    }
}
