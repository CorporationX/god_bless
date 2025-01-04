package school.faang.bjs250979;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

public class PotionGathering {
    public static void main(String[] args) {
        List<Potion> potions = List.of(
                new Potion("Healing Potion", 5),
                new Potion("Mana Potion", 3),
                new Potion("Stamina Potion", 4)
        );

        gatherAllIngredients(potions);
    }

    private static void gatherAllIngredients(List<Potion> potions) {
        AtomicInteger count = new AtomicInteger(0);

        CompletableFuture<Void>[] potionsFutures = potions.stream()
                .map(potion -> CompletableFuture.runAsync(() -> {
                    try {
                        Thread.sleep(potion.getRequiredIngredients() * 1000L);
                        System.out.println("It Took: " + potion.getRequiredIngredients()
                                + " seconds to gather all ingredients for " + potion.getName());
                        count.addAndGet(potion.getRequiredIngredients());
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }))
                .toArray(CompletableFuture[]::new);

        CompletableFuture.allOf(potionsFutures).join();

        System.out.println("Общее количество собранных ингредиентов: " + count);
    }
}
