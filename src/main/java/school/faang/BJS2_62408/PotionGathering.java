package school.faang.BJS2_62408;

import lombok.NonNull;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class PotionGathering {

    public static void sleep(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("Task interrupted", e);
        }
    }

    public static int gatherIngredients(@NonNull Potion potion) {
        sleep(1000L * potion.requiredIngredients());
        return potion.requiredIngredients();
    }

    public static void gatherAllIngredients(@NonNull List<Potion> potions) {
        List<CompletableFuture<Integer>> futures = potions
                .stream()
                .map(potion -> CompletableFuture.supplyAsync(() -> gatherIngredients(potion)))
                .toList();
        CompletableFuture<Void> allDone = CompletableFuture.allOf(futures.toArray(CompletableFuture[]::new));

        allDone.thenApply(v -> futures.stream()
                        .map(CompletableFuture::join)
                        .mapToInt(Integer::intValue)
                        .sum())
                .thenAccept((sum) ->
                        System.out.println("Total amount of ingredients: %d".formatted(sum)))
                .join();
    }

    public static void main(String[] args) {
        List<Potion> potions = List.of(
                new Potion("Healing Potion", 5),
                new Potion("Mana Potion", 3),
                new Potion("Stamina Potion", 4)
        );

        gatherAllIngredients(potions);
    }
}
