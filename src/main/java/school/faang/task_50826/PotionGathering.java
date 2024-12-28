package school.faang.task_50826;

import java.util.ArrayList;
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
        List<CompletableFuture<Potion>> futureList = new ArrayList<>();
        potions.stream().map(potion -> collectIngridients(potion)).forEach(future -> futureList.add(future));

        AtomicInteger totalQuantity = new AtomicInteger(0);
        futureList.forEach(future -> totalQuantity.addAndGet(future.join().getRequiredIngredients()));
        System.out.println(String.format("Total amount of ingredients collected: %d", totalQuantity.get()));
    }

    private static CompletableFuture<Potion> collectIngridients(Potion potion) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println(String.format("Begin of collecting ingredients for the potion %s...",
                        potion.getName()));
                Thread.sleep(1000 * potion.getRequiredIngredients());
                System.out.println(String.format("Ingredients for the potion %s is collected.",
                        potion.getName()));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return potion;
        });
    }
}