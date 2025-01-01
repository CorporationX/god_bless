package school.faang.moduleone.sprintfour.task_43583;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class PotionGathering {
    public static void main(String[] args) {
        List<Potion> potions = List.of(
                new Potion("Healing Potion", 5),
                new Potion("Mana Potion", 3),
                new Potion("Stamina Potion", 4)
        );

        // Асинхронный сбор ингредиентов
        int totalIngredientsSum = gatherAllIngredients(potions);
        log.info("total ingredients sum = {}", totalIngredientsSum);
    }

    private static int gatherAllIngredients(List<Potion> potions) {
        List<CompletableFuture<Integer>> futureIngredients = potions.stream()
                .map(potion -> CompletableFuture.supplyAsync(() -> {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    return potion.getRequiredIngredients();
                }))
                .toList();

        CompletableFuture.allOf(futureIngredients.toArray(new CompletableFuture[0]))
                .join();

        AtomicInteger totalSum = new AtomicInteger(0);
        for (CompletableFuture<Integer> futureIngredient : futureIngredients) {
            try {
                totalSum.addAndGet(futureIngredient.get());
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }
        }
        return totalSum.get();
    }
}
