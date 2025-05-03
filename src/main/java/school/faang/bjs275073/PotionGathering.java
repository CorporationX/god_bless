package school.faang.bjs275073;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Slf4j
public class PotionGathering {
    private static final int WAITING_TIME = 1_000;

    public static void main(String[] args) {
        List<Potion> potions = List.of(
                new Potion("Healing Potion", 5),
                new Potion("Mana Potion", 3),
                new Potion("Stamina Potion", 4)
        );

        List<CompletableFuture<Integer>> ingredientResults = gatherAllIngredients(potions);
        CompletableFuture.allOf(ingredientResults.toArray(new CompletableFuture[0])).join();

        int totalIngredientsCount = calculateTotalIngredientsCount(ingredientResults);
        log.info("Общее количество собранных ингредиентов: {}", totalIngredientsCount);
    }

    private static List<CompletableFuture<Integer>> gatherAllIngredients(List<Potion> potions) {
        return potions.stream()
                .map(PotionGathering::gatherIngredients)
                .toList();
    }

    private static CompletableFuture<Integer> gatherIngredients(Potion potion) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep((long) WAITING_TIME * potion.getRequiredIngredients());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                log.error("Ingredients for {} gathering interrupted: {}", potion.getName(), e.getMessage());
            }
            return potion.getRequiredIngredients();
        });
    }

    private static int calculateTotalIngredientsCount(List<CompletableFuture<Integer>> ingredientResults) {
        return ingredientResults.stream()
                .map((result) -> {
                    try {
                        return result.get();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        log.error("Thread interrupted: {}", e.getMessage());
                        throw new RuntimeException(e);
                    } catch (ExecutionException e) {
                        log.error("Execution exception: {}", e.getMessage());
                        throw new RuntimeException(e);
                    }
                })
                .reduce(0, Integer::sum);
    }
}
