package school.faang.alchemy;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

public record Potion(String name, int requiredIngredients) {

    public CompletableFuture<Integer> gatherIngredients() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
            return requiredIngredients();
        });
    }

    public static CompletableFuture<Integer> gatherAllIngredients(List<Potion> potions) {
        List<CompletableFuture<Integer>> futures = potions.stream()
                .map(Potion::gatherIngredients)
                .toList();

        AtomicInteger totalIngredients = new AtomicInteger(0);

        CompletableFuture<Void> allOf = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));

        return allOf.thenApply(v -> futures.stream()
                .map(CompletableFuture::join)
                .mapToInt(totalIngredients::addAndGet)
                .sum());
    }
}
