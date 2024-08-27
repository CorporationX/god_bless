package faang.school.godbless.alhimiya;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    private static final AtomicInteger sumOfAllIngredients = new AtomicInteger(0);

    public static void main(String[] args) {
        PotionService potionService = new PotionService();

        List<Potion> potions = List.of(
                new Potion("Understand map", 2),
                new Potion("Understand git", 3),
                new Potion("Understand concurrency", 10),
                new Potion("Understand CompletableFuture", 7)
        );

        CompletableFuture.allOf(potions.stream()
                .map(potion -> CompletableFuture.supplyAsync(() -> potionService.gatherIngredients(potion))
                        .thenApply(sumOfAllIngredients::addAndGet))
                .toArray(CompletableFuture[]::new)
        ).join();

        System.out.println(sumOfAllIngredients);
    }
}
