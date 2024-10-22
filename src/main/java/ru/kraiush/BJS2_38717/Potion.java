package ru.kraiush.BJS2_38717;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

@Data
@AllArgsConstructor
public class Potion {
    private String name;
    private int requiredIngredients;

    public static void gatherAllIngredients(List<Potion> potions) {
        List<CompletableFuture<Integer>> ingredientFutures = potions.stream()
                .map((potion) -> CompletableFuture.supplyAsync(() -> {
                    try {
                        Thread.sleep(3_000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return potion.getRequiredIngredients();
                }))
                .toList();
        AtomicInteger allRequiredIngredients = new AtomicInteger();
        ingredientFutures.forEach(ingredientFuture -> allRequiredIngredients.addAndGet(ingredientFuture.join()));
        System.out.println("All required ingredientFutures for the List of potions: " + allRequiredIngredients.get());
    }
}
