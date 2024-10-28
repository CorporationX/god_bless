package school.faang.alchemy;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        List<Potion> potions = List.of(
                new Potion("Healing Potion", 5),
                new Potion("Mana Potion", 3),
                new Potion("Stamina Potion", 4)
        );
        gatherAllIngredients(potions);
    }

    public static void gatherAllIngredients(List<Potion> potions) {
        List<CompletableFuture<Integer>> completableFutureList = potions
                .stream()
                .map(potion -> CompletableFuture.supplyAsync(() -> potion.gatherIngredients(potion)))
                .toList();
        CompletableFuture<Void> allFutures =
                CompletableFuture.allOf(completableFutureList.toArray(new CompletableFuture[0]));

        allFutures.thenRun(() -> {
            completableFutureList.forEach(future -> Potion.totalIngredients.addAndGet(future.join()));
            System.out.println("Total amount of ingredients: " + Potion.totalIngredients);
        }).join();
    }
}