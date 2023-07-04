package faang.school.godbless.alchemy;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Alchemist {
    public static void main(String[] args) {
        List<Potion> potions = Arrays.asList(
                new Potion("Health Potion", 5),
                new Potion("Strength Potion", 4),
                new Potion("Speed Potion", 6),
                new Potion("Poison Resistance Potion", 2)
        );

        @SuppressWarnings("unchecked")
        CompletableFuture<Integer>[] ingredientTasks = potions.stream()
                .map(Alchemist::gatherIngredientsAsync)
                .toArray(CompletableFuture[]::new);

        CompletableFuture<Void> allIngredientsTask = CompletableFuture.allOf(ingredientTasks);

        CompletableFuture<Integer> totalIngredientsTask = allIngredientsTask.thenApply(
                v -> Arrays.stream(ingredientTasks)
                        .map(CompletableFuture::join)
                        .reduce(0, Integer::sum)
        );

        try {
            int totalIngredients = totalIngredientsTask.get();
            System.out.println("Total ingredients collected: " + totalIngredients);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    private static CompletableFuture<Integer> gatherIngredientsAsync(Potion potion) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Ingredients gathered for: " + potion.getName());
            return potion.getRequiredIngredients();
        });
    }

}
