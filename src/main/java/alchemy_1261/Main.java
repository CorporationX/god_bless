package alchemy_1261;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Main {
    static int totalIngredients;

    public static void main(String[] args) {

        List<Potion> potions = List.of(
                new Potion("P_1", 14),
                new Potion("P_2", 9),
                new Potion("P_3", 20),
                new Potion("P_4", 2)
        );

        List<CompletableFuture<Integer>> ingredientsFuture = new ArrayList<>();

        potions.stream()
                .forEach((potion) -> ingredientsFuture.add(CompletableFuture.supplyAsync(() -> gatherIngredients(potion)))
                );

        CompletableFuture<Void> allFuture =
                CompletableFuture.allOf(ingredientsFuture.toArray(new CompletableFuture[ingredientsFuture.size()]));

        totalIngredients = allFuture.thenApply((v) -> ingredientsFuture.stream()
                        .map(CompletableFuture::join)
                        .mapToInt(Integer::intValue)
                        .sum())
                .join();

        System.out.println("TOTAL - " + totalIngredients);
    }

    public static int gatherIngredients(Potion potion) {
        try {
            System.out.println("Начинаем сбор ингредиента - " + potion.getName());
            Thread.sleep(3000);
            return potion.getRequiredIngredients();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("Что-то пошло не так..");
        }
    }
}