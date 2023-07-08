package faang.school.godbless.sprint4.alchemy;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Potion potion1 = new Potion("Elixir of Agony", 5);
        Potion potion2 = new Potion("Flask of Truth", 8);
        Potion potion3 = new Potion("Potion of the Sun", 15);

        List<Potion> potions = List.of(potion1, potion2, potion3);

        List<CompletableFuture<Integer>> gatherIngredientsFutures = potions.stream()
                .map(potion -> CompletableFuture.supplyAsync(() -> gatherIngredients(potion)))
                .toList();

        CompletableFuture<Void> allFutures = CompletableFuture.allOf(
                gatherIngredientsFutures.toArray(new CompletableFuture[0]));

        allFutures.get();

        int totalIngredients = gatherIngredientsFutures.stream()
                .map(CompletableFuture::join)
                .reduce(0, Integer::sum);

        System.out.println("Total ingredients: " + totalIngredients);
    }

    public static int gatherIngredients(Potion potion) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return potion.getRequiredIngredients();
    }
}
