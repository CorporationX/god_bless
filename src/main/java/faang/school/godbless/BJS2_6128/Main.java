package faang.school.godbless.BJS2_6128;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) {
        List<Potion> potions = List.of(
                new Potion("flight potion", 3),
                new Potion("power potion", 5),
                new Potion("health potion", 4),
                new Potion("invisible potion", 3),
                new Potion("lucky potion", 7)
        );
        ExecutorService executorService = Executors.newFixedThreadPool(potions.size());
        AtomicInteger summaryIngredients = new AtomicInteger();
        List<CompletableFuture<Integer>> completableFutures = new ArrayList<>();


        for (Potion potion : potions) {
            CompletableFuture<Integer> potionFuture = CompletableFuture.supplyAsync(
                    () -> potion.gatherIngredients(potion), executorService).thenApply(summaryIngredients::getAndAdd);
            completableFutures.add(potionFuture);

        }

        CompletableFuture.allOf(completableFutures.toArray(new CompletableFuture[0])).join();

        try {
            executorService.shutdown();
            if (!executorService.awaitTermination(10, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(summaryIngredients.get());
    }
}
