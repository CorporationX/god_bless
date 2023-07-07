package faang.school.godbless.asyncAndFuture.alchemy;

import lombok.Getter;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class Producer {
    private final int NUMBER_THREADS = 5;
    private final ExecutorService executorService = Executors.newFixedThreadPool(NUMBER_THREADS);
    private AtomicInteger ingredientsNumber;

    public Producer() {
        this.ingredientsNumber = new AtomicInteger(0);
    }

    public List<CompletableFuture<Void>> doPotions(List<Potion> potions) {
        ingredientsNumber.set(0);
        return potions.stream()
                .map(potion ->
                    CompletableFuture.runAsync(() -> ingredientsNumber.addAndGet(potion.gatherIngredients()), executorService)
                ).toList();
    }

    public Integer getIngredientsNumber() {
        return ingredientsNumber.get();
    }

    public void shutdown() {
        executorService.shutdown();
    }
}
