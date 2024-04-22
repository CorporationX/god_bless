package faang.school.godbless.collect_orders_on_amazon;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class Main {
    public static void main(String[] args) {
        OrderProcessor orderProcessor = new OrderProcessor();
        List<Order> orders = initialize();
        List<CompletableFuture<Void>> futures = new ArrayList<>();
        ExecutorService executorService = Executors.newFixedThreadPool(orders.size());

        orders.forEach(order -> futures.add(orderProcessor.processOrder(order, executorService)));

        futures.forEach(CompletableFuture::join);
        executorService.shutdown();
        log.info("Total processed orders: {}", orderProcessor.getTotalProcessedOrders());
    }

    public static List<Order> initialize() {
        return List.of(
                new Order(),
                new Order(),
                new Order(),
                new Order(),
                new Order(),
                new Order(),
                new Order(),
                new Order(),
                new Order(),
                new Order(),
                new Order(),
                new Order()
        );
    }
}