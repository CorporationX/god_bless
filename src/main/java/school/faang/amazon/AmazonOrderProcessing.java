package school.faang.amazon;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Slf4j
public class AmazonOrderProcessing {

    public static void main(String[] args) {

        OrderProcessor orderProcessor = new OrderProcessor();
        List<Order> orders = List.of(new Order(), new Order(), new Order());

        List<CompletableFuture<Void>> ordersFuture = orders.stream().map(orderProcessor::processOrder).toList();
        CompletableFuture<Void> allOrdersCompleted =
                CompletableFuture.allOf(ordersFuture.toArray(new CompletableFuture[0]));
        allOrdersCompleted.thenRun(() ->
                log.info("Все заказы обработаны. Общее количество: {}", orderProcessor.getTotalProcessedOrders()));

        allOrdersCompleted.join();
    }
}
