package school.faang.task_50863;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;

@Slf4j
public class PotionGathering {
    public static int gatherIngredients(Potion potion) {
        try {
            Thread.sleep(potion.getRequiredIngredients());
        } catch (InterruptedException e) {
            log.warn("Thread was interrupted", e);
            Thread.currentThread().interrupt();
            throw new CompletionException(e);
        }

        return potion.getRequiredIngredients();
    }

    public static void gatherAllIngredients(List<Potion> potions) {
        List<CompletableFuture<Integer>> ingredients = potions.stream()
                .map(potion -> CompletableFuture.supplyAsync(() -> gatherIngredients(potion)))
                .toList();

        CompletableFuture.allOf(ingredients.toArray(new CompletableFuture[0]))
                .thenRun(() -> {
                    int total = ingredients.stream()
                            .map(CompletableFuture::join)
                            .reduce(0, Integer::sum);
                    System.out.println("Общее количество собранных ингредиентов: " + total);
                }).join();
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
