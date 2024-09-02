package faang.school.godbless;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Potion> potions = Arrays.asList(
                new Potion("Зелье здоровья", 5),
                new Potion("Зелье маны", 3),
                new Potion("Strength Potion", 7)
        );

        AtomicInteger totalIngredients = new AtomicInteger();

        List<CompletableFuture<Integer>> futures = potions.stream()
                .map(potion -> gatherIngredients(potion, totalIngredients))
                .collect(Collectors.toList());

        CompletableFuture<Void> allOf = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));

        allOf.join();

        System.out.println("Всего ингредиентов собрано: " + totalIngredients);
    }

    public static CompletableFuture<Integer> gatherIngredients(Potion potion, AtomicInteger totalIngredients) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2_000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            totalIngredients.addAndGet(potion.getRequiredIngredients());

            return potion.getRequiredIngredients();
        });
    }
}
