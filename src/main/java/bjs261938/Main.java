package bjs261938;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Slf4j
public class Main {
    public static void main(String[] args) {
        OrderProcessor orderProcessor = new OrderProcessor();
        CompletableFuture.allOf(orderProcessor.processAllOrders(initializeListOrders())
                .toArray(new CompletableFuture[0])).join();
        orderProcessor.shutDownExecutorService();
        log.info("Обработано заказов: {}", orderProcessor.getTotalProcessedOrders().get());
    }

    private static List<Order> initializeListOrders() {
        return List.of(new Order(1, Status.NEW), new Order(2, Status.NEW), new Order(3, Status.NEW),
                new Order(4, Status.NEW));
    }
}
