package faang.school.godbless.bjs2_24753;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Slf4j
public class Main {
    private static final int ORDERS_AMOUNT = 10;

    public static void main(String[] args) {
        List<Order> orders = initOrders();
        OrderProcessor orderProcessor = new OrderProcessor(orders.size());

        CompletableFuture
                .allOf(orders.stream()
                        .map(orderProcessor::processOrder)
                        .toArray(CompletableFuture[]::new))
                .thenAccept(v -> orderProcessor.finish())
                .thenAccept(v -> log.info("Number of processed orders: {}", orderProcessor.getNumbersProcessedOrders()))
                .join();
    }

    private static List<Order> initOrders() {
        List<Order> order = new ArrayList<>();
        for (int i = 1; i <= ORDERS_AMOUNT; i++) {
            order.add(new Order(i));
        }
        return order;
    }
}
