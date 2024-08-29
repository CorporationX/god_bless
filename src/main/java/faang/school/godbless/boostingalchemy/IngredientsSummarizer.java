package faang.school.godbless.boostingalchemy;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class IngredientsSummarizer {
    private static final ExecutorService EXECUTOR_SERVICE = Executors.newCachedThreadPool();
    private final AtomicInteger sumOfIngredients;
    private final List<Potion> potions;

    public IngredientsSummarizer() {
        this.sumOfIngredients = new AtomicInteger(0);
        this.potions = getPotions();
    }

    public void sumIngredients() {
        CompletableFuture<Void> future = CompletableFuture.allOf(potions.stream()
                .map(potion -> CompletableFuture.supplyAsync(() -> IngredientsGatherer.gatherIngredients(potion))
                        .thenApplyAsync(sumOfIngredients::addAndGet, EXECUTOR_SERVICE))
                .toArray(CompletableFuture[]::new));
        future.join();
        System.out.println(sumOfIngredients);
    }

    public void shutdown() {
        EXECUTOR_SERVICE.shutdown();
    }

    private List<Potion> getPotions() {
        return List.of(
                new Potion("Potion of Cure Disease", 7),
                new Potion("Potion of Alteration", 5),
                new Potion("Elixir of Haggling", 3),
                new Potion("Philter of the Defender", 8),
                new Potion("Solution of Strength", 6),
                new Potion("Conjurer's Draught", 5)
        );
    }
}