package faang.school.godbless.multithreading.alchemy;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {
    public static int gatherIngredients(Potion potion){
        try {
            Thread.sleep(potion.requiredIngredients() * 500L);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return potion.requiredIngredients();
    }
    public static void main(String[] args) {
        List<Potion> potions = List.of(
                new Potion("Healing Potion", 3),
                new Potion("Mana Potion", 2),
                new Potion("Strength Potion", 4),
                new Potion("Invisibility Potion", 5),
                new Potion("Speed Potion", 6)
        );

        List<CompletableFuture<Integer>> completableFutures = potions.stream()
                .map(potion -> CompletableFuture.supplyAsync(() -> gatherIngredients(potion)))
                .toList();

        CompletableFuture<Void> allOf = CompletableFuture.allOf(completableFutures.toArray(new CompletableFuture[0]));

        var sum = allOf.thenApply(v -> completableFutures.stream()
                        .mapToInt(CompletableFuture::join)
                        .sum())
                .join();

        System.out.println("Sum of results: " + sum);
    }
}
