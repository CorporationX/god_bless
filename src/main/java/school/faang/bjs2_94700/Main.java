package school.faang.bjs2_94700;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Slf4j
public class Main {
    public static void main(String[] args) {
        PotionGatherer potionGatherer = new PotionGatherer();
        List<Potion> potions = List.of(
                new Potion("Restore Health Potion", 2),
                new Potion("Resist Poison Potion", 2),
                new Potion("Invisibility Potion", 2)
        );

        List<CompletableFuture<Integer>> allGatheredIngredients = potions.stream()
                .map(potionGatherer::gatherIngredients)
                .toList();
        CompletableFuture.allOf(allGatheredIngredients.toArray(new CompletableFuture[0]));
        int amountOfGatheredIngredients = allGatheredIngredients.stream()
                .mapToInt(future -> {
                    try {
                        return future.get();
                    } catch (InterruptedException | ExecutionException e) {
                        log.error(e.getMessage());
                    }
                    return 0;
                })
                .sum();
        log.info("Всего собрано ингредиентов: {}", amountOfGatheredIngredients);
        potionGatherer.shutdownCorrectly();
    }
}
