package faang.school.godbless.alhimic;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicInteger;

@AllArgsConstructor
public class Potion {
    private String name;
    private int requiredIngredients;

    public static void main(String[] args) {
        AtomicInteger sum = new AtomicInteger();

        List<Potion> potions = new ArrayList<>();
        fillingInList(potions);
        List<CompletableFuture<Integer>> futures = new ArrayList<>();
        for (Potion potion : potions) {
            CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> gatherIngredients(potion))
                    .thenApply(sum::addAndGet);
            futures.add(future);
        }
        CompletableFuture<Void> allOf = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));
        try {
            allOf.get();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
        System.out.println(sum);
    }

    public static int gatherIngredients(Potion potion) {
        System.out.println("Собираем ингредиенты для " + potion.name);
        try {
            Thread.sleep(1000L * potion.requiredIngredients);
            System.out.println(potion.name + ": ингредиентов собрано - " + potion.requiredIngredients);
            return potion.requiredIngredients;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private static void fillingInList(List<Potion> potions) {
        potions.add(new Potion("potion", 5));
        potions.add(new Potion("potion1", 3));
        potions.add(new Potion("potion2", 7));
        potions.add(new Potion("potion3", 4));
        potions.add(new Potion("potion4", 2));
        potions.add(new Potion("potion5", 1));
    }
}
