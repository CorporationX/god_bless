package school.faang.task_50912;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public record Potion(String name, int requiredIngredients) {
    public static CompletableFuture<Integer> gatherIngredients(Potion potion) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.MILLISECONDS.sleep(2000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
            return potion.requiredIngredients();
        }).orTimeout(3, TimeUnit.SECONDS);
    }

    public static void gatherAllIngredients(List<Potion> potions) {
        AtomicInteger totalIngredients = new AtomicInteger(0);

        List<CompletableFuture<Integer>> futures = potions.stream()
                .map(Potion::gatherIngredients)
                .toList();

        CompletableFuture<Void> allOf = CompletableFuture
                .allOf(futures.toArray(CompletableFuture[]::new));

        allOf.thenRun(() -> {
            futures.forEach(future -> {
                try {
                    totalIngredients.addAndGet(future.get());
                } catch (InterruptedException | ExecutionException ignored) {
                }
            });

            System.out.println("Total ingredients gathered: " + totalIngredients.get());
        }).join();
    }
}