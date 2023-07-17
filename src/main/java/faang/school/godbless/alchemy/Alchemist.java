package faang.school.godbless.alchemy;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicInteger;

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

        AtomicInteger totalIngredients = new AtomicInteger(0);

        CompletableFuture<Void> updateTotalIngredientsTask = allIngredientsTask.thenAccept(
                v -> {
                    int sum = Arrays.stream(ingredientTasks)
                            .map(CompletableFuture::join)
                            .reduce(0, Integer::sum);
                    totalIngredients.set(sum);
                }
        );

        try {
            updateTotalIngredientsTask.get();
            System.out.println("Total ingredients collected: " + totalIngredients.get());
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

            System.out.println("Ingredients gathered for " + potion.getName());
            return potion.getRequiredIngredients();
        });
    }

}
