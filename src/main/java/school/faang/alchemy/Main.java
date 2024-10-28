package school.faang.alchemy;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    private static final AtomicInteger totalIngredients = new AtomicInteger(0);
    public static void main(String[] args) {
        List<Potion> potions = List.of(
                new Potion("Healing Potion", 5),
                new Potion("Mana Potion", 3),
                new Potion("Stamina Potion", 4)
        );
        gatherAllIngredients(potions);
    }

    private static void gatherAllIngredients(List<Potion> potions) {
        List<CompletableFuture<Integer>> completableFutureList = potions
                .stream()
                .map(potion -> CompletableFuture.supplyAsync(() -> gatherIngredients(potion)))
                .toList();
        CompletableFuture<Void> allFutures =
                CompletableFuture.allOf(completableFutureList.toArray(new CompletableFuture[0]));

        allFutures.thenRun(() -> {
            completableFutureList.forEach(future -> totalIngredients.addAndGet(future.join()));
            System.out.println("Total amount of ingredients: " + totalIngredients);
        }).join();
    }
    private static int gatherIngredients(Potion potion) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return potion.requiredIngredients();
    }
}