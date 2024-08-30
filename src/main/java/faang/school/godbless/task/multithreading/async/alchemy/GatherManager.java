package faang.school.godbless.task.multithreading.async.alchemy;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
@Getter
public class GatherManager {
    private static final int ONE_INGREDIENT_GATHER_TIME = 500;

    private final ExecutorService executor;

    public GatherManager(int threadPoolSize) {
        this.executor = Executors.newFixedThreadPool(threadPoolSize);
    }

    public CompletableFuture<Integer> gatherIngredients(Potion potion) {
        return CompletableFuture.supplyAsync(() -> gather(potion), executor);
    }

    private int gather(Potion potion) {
        int ingredients = potion.requiredIngredients();
        log.info("Find {} ingredients for {}", ingredients, potion.name());
        sleep(ingredients);
        return ingredients;
    }

    private void sleep(int ingredients) {
        try {
            Thread.sleep(ingredients * ONE_INGREDIENT_GATHER_TIME);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
