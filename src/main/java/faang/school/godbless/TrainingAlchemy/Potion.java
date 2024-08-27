package faang.school.godbless.TrainingAlchemy;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@AllArgsConstructor
@Getter
@Setter
public class Potion {
    private String name;
    private int requiredIngredients;

    public static int gatherIngredients(Potion potion) {
        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(800);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        return potion.requiredIngredients;
    }

    public static void main(String[] args) {
        List<Potion> potions = new ArrayList<>();

        potions.add(new Potion("Potion of Healing", 3));
        potions.add(new Potion("Potion of Strength", 5));
        potions.add(new Potion("Potion of Agility", 2));
        potions.add(new Potion("Potion of Intelligence", 4));
        potions.add(new Potion("Potion of Wisdom", 6));

        List<CompletableFuture<Integer>> completableFutures = potions.stream()
                .map(potion -> CompletableFuture.supplyAsync(() -> gatherIngredients(potion)))
                .collect(Collectors.toList());
        CompletableFuture<Void> allFutures = CompletableFuture.allOf(completableFutures.toArray(new CompletableFuture[0]));
        allFutures.thenRun(() -> {
            AtomicInteger sum = new AtomicInteger();
            completableFutures.forEach(future -> {
                try {
                    int ingredients = future.get();
                    sum.addAndGet(ingredients);
                    System.out.println("Gathered " + ingredients + " ingredients");
                } catch (Exception e) {
                    System.out.println("Error gathering ingredients: " + e.getMessage());
                }
            });
            System.out.println("Сумма всех ингридиентов: " + sum);
        });
    }
}

