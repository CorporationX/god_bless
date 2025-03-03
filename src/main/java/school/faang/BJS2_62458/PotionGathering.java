package school.faang.BJS2_62458;

import lombok.extern.slf4j.Slf4j;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class PotionGathering {
    private static final int NUM_THREADS = 7;
    private static final int NUM_POTION = 50;
    private static final String ERROR_IN_THE_THREAD = "Error in the thread:\n{}";
    private static final String GETTING_INGREDIENTS_FOR_POTION = "Getting ingredients for potion '{}' - {}";
    private static final String TOTAL_COUNT_INGREDIENTS = "Total count ingredients: {}";
    private static final ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);

    public static void main(String[] args) {
        List<Potion> potions = new ArrayList<>();
        for (int i = 0; i < NUM_POTION; i++) {
            potions.add(new Potion("Potion #" + i, i));
        }
        gatherAllIngredients(potions);
        shutdownExecutor();
    }

    private static CompletableFuture<Integer> gatherIngredients(Potion potion) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(potion.getRequiredIngredients());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                log.error(ERROR_IN_THE_THREAD, e);
                return 0;
            }
            int result = potion.getRequiredIngredients();
            log.info(GETTING_INGREDIENTS_FOR_POTION, potion.getName(), result);
            return result;
        }, executor);
    }

    private static void gatherAllIngredients(List<Potion> potions) {
        AtomicInteger totalCountIngredients = new AtomicInteger();
        List<CompletableFuture<Void>> futures = potions.stream()
                .map(PotionGathering::gatherIngredients)
                .map(future -> future.thenAccept(totalCountIngredients::addAndGet))
                .toList();
        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();
        log.info(TOTAL_COUNT_INGREDIENTS, totalCountIngredients.get());
    }

    private static void shutdownExecutor() {
        executor.shutdown();
        try {
            if (!executor.awaitTermination(2, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }
    }
}
