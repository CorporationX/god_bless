package school.faang.bjs2_82637;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static final int NUM_THREADS = 4;
    private static final int TIMEOUT_IN_SEC = 10;

    public static void main(String[] args) {
        ExecutorService poolThreads = Executors.newFixedThreadPool(NUM_THREADS);

        List<Potion> potions = List.of(
                new Potion("Healing Potion", 5),
                new Potion("Mana Potion", 3),
                new Potion("Stamina Potion", 4)
        );

        IngredientGatherer gatherer = new IngredientGatherer(poolThreads);

        List<CompletableFuture<Integer>> ingredients = gatherer.collectAllIngredients(potions);
        CompletableFuture
                .allOf(ingredients.toArray(new CompletableFuture[0]))
                .thenApply(v -> ingredients.stream().mapToInt(CompletableFuture::join).sum())
                .thenAccept(quantity -> System.out.printf("Всего собрано ингредиентов: %s%n", quantity));

        breakPoolThreads(poolThreads);
    }

    private static void breakPoolThreads(ExecutorService poolThreads) {
        poolThreads.shutdown();
        try {
            if (!poolThreads.awaitTermination(TIMEOUT_IN_SEC, TimeUnit.SECONDS)) {
                log.info("Досрочное завершение потоков");
                poolThreads.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.warn("Досрочное завершение потоков", e);
            poolThreads.shutdownNow();
        }
    }
}
