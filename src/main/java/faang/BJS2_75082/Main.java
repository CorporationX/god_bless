package faang.BJS2_75082;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

@Slf4j
public final class Main {
    private static final List<Potion> POTIONS = List.of(
            new Potion("Daniyal", 4),
            new Potion("Lada", 2)
    );

    public static void main(final String[] args) {
        final List<CompletableFuture<Integer>> completableFutures = POTIONS.stream()
                .map(potion -> CompletableFuture.supplyAsync(() -> gatherIngredients(potion)))
                .toList();

        allOf(completableFutures).join();
        int ingredientsCount = getIngredientsCount(completableFutures);
        log.info("Ingredients: {}", ingredientsCount);
    }

    private static int getIngredientsCount(List<CompletableFuture<Integer>> completableFutures) {
        return completableFutures.stream()
                .mapToInt(CompletableFuture::join)
                .sum();
    }

    private static CompletableFuture<Void> allOf(List<CompletableFuture<Integer>> completableFutures) {
        return CompletableFuture.allOf(completableFutures.toArray(new CompletableFuture[0]));
    }

    public static int gatherIngredients(Potion potion) {
        try {
            TimeUnit.SECONDS.sleep(potion.requiredIngredients());
            return potion.requiredIngredients();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }
}
