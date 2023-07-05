package faang.school.godbless.Alchemy;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    private static AtomicInteger totalIngredients = new AtomicInteger();

    public static void main(String[] args) {
        List<Potion> potions = List.of(
                new Potion("Зелье невидимости", 9),
                new Potion("Зелье лечения", 4),
                new Potion("Зелье силы", 5)
        );

        List<CompletableFuture<Integer>> ingredients = potions.stream().map(potion -> gatherIngredients(potion)).toList();

        CompletableFuture.allOf(ingredients.toArray(new CompletableFuture[ingredients.size()]));

        System.out.println(ingredients.stream().mapToInt(future -> {
            try {
                return future.get();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            }
        }).sum());
    }

    public static CompletableFuture<Integer> gatherIngredients(Potion potion) {
        CompletableFuture<Integer> futureIngredients = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return potion.getRequiredIngredients();
        });
        return futureIngredients;
    }
}
