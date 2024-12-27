package school.faang.alchemy;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class PotionGathering {
    public static void main(String[] args) {
        List<Potion> potions = List.of(
                new Potion("Healing Potion", 5),
                new Potion("Mana Potion", 3),
                new Potion("Stamina Potion", 4)
        );

        // Асинхронный сбор ингредиентов
        gatherAllIngredients(potions);
    }

    private static void gatherAllIngredients(List<Potion> potions) {
        List<CompletableFuture<Integer>> ingredientsCount = potions.stream().map(
                potion ->
                        CompletableFuture.supplyAsync(() ->
                                gatherIngredients(potion))).toList();
        CompletableFuture<Void> result = CompletableFuture.allOf(ingredientsCount.toArray(new CompletableFuture[0]));

        while (!result.isDone()) {
            System.out.println("gathering...");
            try {
                Thread.sleep(40);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static int gatherIngredients(Potion potion) {
        try {
            Thread.sleep(potion.ingredientsCount() * 100L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Ingredients for " + potion.name() + "  is gathered");
        return potion.ingredientsCount();
    }
}
