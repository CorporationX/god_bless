package school.faang.task_50892;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class PotionGathering {
    private static final int COLLECTION_TIME = 2000;

    public static void main(String[] args) {
        List<Potion> potions = List.of(
                new Potion("Healing Potion", 5),
                new Potion("Mana Potion", 3),
                new Potion("Stamina Potion", 4)
        );

        gatherAllIngredients(potions);
    }

    private static int gatherIngredients(Potion potion) {
        try {
            Thread.sleep(COLLECTION_TIME);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return potion.ingredients();
    }

    private static void gatherAllIngredients(List<Potion> potions) {
        List<CompletableFuture<Integer>> futures = potions.stream()
                .map(potion -> CompletableFuture.supplyAsync(() -> gatherIngredients(potion)))
                .toList();
        CompletableFuture<Void> allOf = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));

        int totalIngredients = futures.stream()
                .mapToInt(CompletableFuture::join)
                .sum();
        System.out.println("Общее колво собранных ингредиентов = " + totalIngredients);
    }
}

