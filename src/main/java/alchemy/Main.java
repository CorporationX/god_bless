package alchemy;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Main {
    public static void main(String[] args) {
        Potion potion1 = new Potion("Potion1", List.of("ingredient 1", "ingredient 2", "ingredient 3"));
        Potion potion2 = new Potion("Potion2", List.of("ingredient 1 (potion2)", "ingredient 2(potion2)"));
        List<Potion> potions = List.of(potion1, potion2);

        List<CompletableFuture<List<String>>> allIngredients = new ArrayList<>();

        potions.forEach(potion -> allIngredients.add(gatherIngredients(potion)));

        allIngredients.forEach(CompletableFuture::join);
        allIngredients.forEach(ing -> {
            try {
                System.out.println(ing.get());
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }
        });
    }

    public static CompletableFuture<List<String>> gatherIngredients(Potion potion) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000L * potion.getRequiredIngredients().size());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return potion.getRequiredIngredients();
        });
    }
}
