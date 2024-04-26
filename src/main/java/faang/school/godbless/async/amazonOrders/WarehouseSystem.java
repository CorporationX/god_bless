package faang.school.godbless.async.amazonOrders;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Slf4j
public class WarehouseSystem {
    private static List<Order> orderList;

    static {
        orderList = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            orderList.add(new Order(i));
        }
    }

    public static void main(String[] args) {
        OrderProcessor orderProcessor = new OrderProcessor();
        List<CompletableFuture<Void>> orderProcessingResults = new ArrayList<>();

        orderList.forEach(order -> orderProcessingResults.add(orderProcessor.processOrder(order)));

        orderProcessor.shutdownThreadPool();

        CompletableFuture.allOf(orderProcessingResults.toArray(new CompletableFuture[0]))
                .join();


        log.info("All orders were processed. The number of processed orders is " + orderProcessor.getTotalProcessedOrdersAmount());
    }
}
