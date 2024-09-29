package ru.kraiush.threads.BJS2_18351;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ThreadLocalRandom;

public class AppCollectingOrders_on_Amazon {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        OrderProcessor processor = new OrderProcessor();

        CompletableFuture<List<Order>> allOrders = new CompletableFuture<>();

        System.out.print(String.join("", Collections.nCopies(80, "-")));
        System.out.println();

        for (int i = 0; i < 5; i++) {
            allOrders = processor.processOrder(new Order(ThreadLocalRandom.current().nextInt(1, 100), OrderType.PROCESSING));
        }
        System.out.println("\nallOrders at the moment: " + allOrders.get());

        CompletableFuture<Long> countFuture = allOrders.thenApply(contents -> {
            return contents.stream()
                    .map(Order::getId)
                    .reduce(0L, Long::sum);
        });

        System.out.println("\nSumming Id's: " + countFuture.get());
        System.out.print(String.join("", Collections.nCopies(80, "-")));
    }
}
