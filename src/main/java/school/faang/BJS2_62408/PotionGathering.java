package school.faang.BJS2_62408;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Slf4j
public class PotionGathering {
    private static final long SLEEP_MULTIPLIER = 1000L;

    public static void sleep(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("Task interrupted", e);
        }
    }

    public static int gatherIngredients(@NonNull Potion potion) {
        sleep(SLEEP_MULTIPLIER * potion.requiredIngredients());
        return potion.requiredIngredients();
    }

    public static CompletableFuture<Integer> gatherAllIngredients(@NonNull List<Potion> potions) {
        List<CompletableFuture<Integer>> futures = potions
                .stream()
                .map(potion -> CompletableFuture.supplyAsync(() -> gatherIngredients(potion)))
                .toList();
        CompletableFuture<Void> allDone = CompletableFuture.allOf(futures.toArray(CompletableFuture[]::new));

        return allDone.thenApply(v -> futures.stream()
                .map(CompletableFuture::join)
                .mapToInt(Integer::intValue)
                .sum());
    }

    public static void main(String[] args) {
        List<Potion> potions = List.of(
                new Potion("Healing Potion", 5),
                new Potion("Mana Potion", 3),
                new Potion("Stamina Potion", 4)
        );

        CompletableFuture<Integer> future = gatherAllIngredients(potions);
        future.thenAccept(sum ->
                System.out.printf("Total amount of ingredients: %d%n", sum));

        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
