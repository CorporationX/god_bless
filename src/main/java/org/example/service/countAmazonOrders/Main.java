package org.example.service.countAmazonOrders;

import lombok.extern.slf4j.Slf4j;
import org.example.model.countAmazonOrders.Order;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

@Slf4j
public class Main {
    public static void main(String[] args) {
        OrderProcessor processor = new OrderProcessor();

        List<Order> orders = List.of(
                new Order(1, "Новый"),
                new Order(2, "Новый"),
                new Order(3, "Новый")
        );

        List<CompletableFuture<Order>> processingOrders = orders.stream()
                .map(processor::processOrder)
                .toList();

        CompletableFuture<Void> allProcessedOrders = CompletableFuture.allOf(processingOrders.toArray(new CompletableFuture[0]));
        allProcessedOrders.thenRun(() -> log.info("total sum of processed orders: {}", processor.getTotalProcessedOrders()));
    }
}
