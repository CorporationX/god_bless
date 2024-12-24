package school.faang.sprint_4.task_50762;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

public class PotionGathering {
    private static final long ONE_ELEMENT_COLLECTING_DELAY = 500L;

    public static void main(String[] args) {
        List<Potion> potions = List.of(
                new Potion("Healing Potion", 5),
                new Potion("Mana Potion", 3),
                new Potion("Stamina Potion", 4)
        );

        List<CompletableFuture<Integer>> completableFutures = gatherAllIngredients(potions);

        AtomicInteger collectedIngredients = new AtomicInteger();
        completableFutures.forEach(future -> collectedIngredients.addAndGet(future.join()));

        System.out.println("Collected " + collectedIngredients.get() + " ingredients");
    }

    private static List<CompletableFuture<Integer>> gatherAllIngredients(List<Potion> potions) {
        return potions.stream()
                .map(potion -> CompletableFuture.supplyAsync(() -> {
                    int requiredIngredients = potion.requiredIngredients();
                    try {
                        Thread.sleep(requiredIngredients * ONE_ELEMENT_COLLECTING_DELAY);
                    } catch (InterruptedException e) {
                        System.out.println("Item collection interrupted");
                        Thread.currentThread().interrupt();
                        return 0;
                    }
                    return requiredIngredients;
                }))
                .toList();
    }
}