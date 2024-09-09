package ru.kraiush.threads.BJS2_18351;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Slf4j
public class OrderProcessor {

    private final AtomicInteger totalProcessedOrders = new AtomicInteger();

    List<CompletableFuture<Order>> listFutures = new ArrayList<>();

    public CompletableFuture<List<Order>> processOrder(Order order) throws ExecutionException {

        try {
            TimeUnit.MILLISECONDS.sleep(ThreadLocalRandom.current().nextInt(1000, 3000));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("Thread Interrupted - " + Thread.currentThread().getName());
        }

        order.setType(OrderType.PROCESSED);
        totalProcessedOrders.incrementAndGet();

        System.out.println("Oh! One more order - " + totalProcessedOrders);

        CompletableFuture<Order> future
                = CompletableFuture.supplyAsync(() -> order);
        listFutures.add(future);

        CompletableFuture<Void> allFutures = CompletableFuture.allOf(
                listFutures.toArray(new CompletableFuture[listFutures.size()]) // <=> null
        );

        CompletableFuture<List<Order>> allContentsFuture = allFutures.thenApply(v -> {
            return listFutures.stream()
                    .map(contentFuture -> contentFuture.join())
                    .collect(Collectors.toList());
        });
        return allContentsFuture;
    }
}
