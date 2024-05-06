package alchemy;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<Potion> potions = new ArrayList<>();
        potions.add(new Potion("some_1", 10));
        potions.add(new Potion("some_2", 5));
        potions.add(new Potion("some_3", 4));
        potions.add(new Potion("some_4", 8));

        List<CompletableFuture<Integer>> futures = potions.stream()
                .map(p -> gatherIngredients(p))
                .toList();

        CompletableFuture<Void> allOf = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));
        allOf.join();

        int countOfRequiredIngredients = 0;
        for (CompletableFuture<Integer> future : futures) {
            countOfRequiredIngredients += future.get();
        }
        System.out.println("Общее кол-во собранных ингредиентов: " + countOfRequiredIngredients);
    }

    private static CompletableFuture<Integer> gatherIngredients(Potion potion) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(3000L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return potion.getRequiredIngredients();
        });
    }
}
