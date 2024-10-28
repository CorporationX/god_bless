package school.faang.alchemy;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

public record Potion(String name,
                     int requiredIngredients) {
    private static final AtomicInteger totalIngredients = new AtomicInteger(0);

    public int gatherIngredients(Potion potion) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return potion.requiredIngredients;
    }

    public static void gatherAllIngredients(List<Potion> potions) {
        List<CompletableFuture<Integer>> completableFutureList = potions
                .stream()
                .map(potion -> CompletableFuture.supplyAsync(() -> potion.gatherIngredients(potion)))
                .toList();
        CompletableFuture<Void> allFutures =
                CompletableFuture.allOf(completableFutureList.toArray(new CompletableFuture[0]));

        allFutures.thenRun(() -> {
            completableFutureList.forEach(future -> totalIngredients.addAndGet(future.join()));
            System.out.println("Total amount of ingredients: " + totalIngredients);
        }).join();
    }
}