package faang.school.godbless;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

public class Alchemist {
    public static void main(String[] args) {
        List<Potion> potions = Arrays.asList(
                new Potion("Healing Potion", 3),
                new Potion("Invisibility Potion", 5),
                new Potion("Strength Potion", 4)
        );

        int totalIngredients = gatherIngredients(potions);

        System.out.println("Total ingredients collected: " + totalIngredients);
    }

    public static int gatherIngredients(List<Potion> potions) {
        List<CompletableFuture<Integer>> ingredientFutures = potions.stream()
                .map(Alchemist::gatherIngredientsAsync)
                .collect(Collectors.toList());

        CompletableFuture<Void> allFutures = CompletableFuture.allOf(ingredientFutures.toArray(new CompletableFuture[0]));
        try {
            allFutures.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        int totalIngredients = ingredientFutures.stream()
                .map(CompletableFuture::join)
                .reduce(0, Integer::sum);

        return totalIngredients;

    }


    public static CompletableFuture<Integer> gatherIngredientsAsync(Potion potion) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return potion.getRequiredIngredients();
        });
    }
}
