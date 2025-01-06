package faang.school.godbless.sprint_4.task_51045;

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

    public static void gatherAllIngredients(List<Potion> potions) {
        List<CompletableFuture<Integer>> potionIngredients = potions.stream()
                .map(potion -> CompletableFuture.supplyAsync(() -> gatherIngredients(potion)))
                .toList();

        CompletableFuture<Void> allPotionIngredients
                = CompletableFuture.allOf(potionIngredients.toArray(new CompletableFuture[0]))
                .thenRun(() -> {
                    AtomicInteger totalAmount = new AtomicInteger();
                    potionIngredients.forEach(result -> result.thenAccept(totalAmount::addAndGet));
                    System.out.println("Общее количество собранных ингредиентов: " + totalAmount.get());
                });

        allPotionIngredients.join();
    }

    public static int gatherIngredients(Potion potion) {
        int potionRequiredIngredients = potion.getRequiredIngredients();
        int ingredientsCollectionTime = potionRequiredIngredients * 1000;
        try {
            Thread.sleep(ingredientsCollectionTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return potionRequiredIngredients;
    }
}
