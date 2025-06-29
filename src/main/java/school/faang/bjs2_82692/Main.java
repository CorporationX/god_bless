package school.faang.bjs2_82692;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) {
        List<Potion> potions = List.of(
                new Potion("1", 1),
                new Potion("2", 4),
                new Potion("3", 6)
        );

        gatherAllIngredients(potions);
    }

    private static void gatherAllIngredients(List<Potion> potions) {
        List<CompletableFuture<Integer>> completableFutures = potions.stream()
                .map(Potion::collectingIngredients)
                .toList();
        completableFutures.forEach(CompletableFuture::join);

        AtomicInteger atomicTotalIngredients = new AtomicInteger(0);
        completableFutures.forEach(future -> future.thenApply(atomicTotalIngredients::addAndGet));

        System.out.printf("Total ingredients: %s%n", atomicTotalIngredients.get());
    }
}