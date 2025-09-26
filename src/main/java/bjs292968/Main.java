package bjs292968;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import static bjs292968.Gather.gatherFuture;

public class Main {
    public static void main(String[] args) {
        List<Potion> potions = List.of(
                new Potion("Healing Potion", 5),
                new Potion("Mana Potion", 3),
                new Potion("Stamina Potion", 4)
        );

        List<CompletableFuture<Integer>> futures = potions.stream().map(potion -> gatherFuture(potion)).toList();
        CompletableFuture<Void> allDone = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));

        allDone.thenRun(() -> {
            int totalIngredients = futures.stream()
                    .mapToInt(future -> future.join())
                    .sum();
            System.out.println("Amounts of all ingredients: " + totalIngredients);
        }).join();
    }
}
