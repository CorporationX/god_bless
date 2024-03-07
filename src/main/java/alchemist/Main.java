package alchemist;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        List<Potion> potions = List.of(
                new Potion("Health Potion", 5),
                new Potion("Invisibility Potion", 3),
                new Potion("Strength Potion", 4)
        );

        Alchemist alchemist = new Alchemist();

        List<CompletableFuture<Integer>> gatherIngredientsFutures = potions.stream()
                .map(alchemist::gatherIngredients)
                .toList();

        CompletableFuture<Void> allOf = CompletableFuture.allOf(
                gatherIngredientsFutures.toArray(new CompletableFuture[0])
        );

        allOf.thenRun(() -> {
            gatherIngredientsFutures.forEach(future -> alchemist.addIngredients(future.join()));
            System.out.println("Total ingredients gathered: " + alchemist.getTotalIngredients());
        }).join();
    }
}
