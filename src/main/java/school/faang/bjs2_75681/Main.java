package school.faang.bjs2_75681;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static school.faang.bjs2_75681.OrderProcessor.totalProcessedOrders;

@Slf4j
public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        OrderProcessor orderProcessor = new OrderProcessor();

        List<Order> orders = List.of(new Order(1), new Order(2), new Order(3));

        List<CompletableFuture<Void>> ordersDone = orders.stream().map(orderProcessor::processOrder).toList();

        CompletableFuture<Void> allOf = CompletableFuture.allOf(ordersDone.toArray(new CompletableFuture[0]));

        allOf.get();
        int totalOrdersProcessed = totalProcessedOrders.get();
        log.info("Всего заказов в процессе: {}", totalOrdersProcessed);
    }
}
