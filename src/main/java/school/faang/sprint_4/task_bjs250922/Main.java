package school.faang.sprint_4.task_bjs250922;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    public static final int EXECUTOR_NUMBER_OF_THREADS = 10;
    public static final long EXECUTOR_AWAIT_TERMINATION = 20L;
    public static final int POTIONS_CAPACITY = 40;
    private static final PotionService POTION_SERVICE = new PotionService();

    public static void main(String[] args) {
        List<Potion> potions = TestDataGenerator.getConcurrentPotions(POTIONS_CAPACITY);
        ExecutorService executors = Executors.newFixedThreadPool(EXECUTOR_NUMBER_OF_THREADS);

        List<CompletableFuture<Integer>> ingredientsFutures = POTION_SERVICE
                .gatherPotionIngredientsFuture(potions, executors);

        int totalIngredients = ingredientsFutures.stream()
                .map(CompletableFuture::join)
                .mapToInt(Integer::intValue)
                .sum();
        log.info("Total ingredients gathered {}", totalIngredients);

        executors.shutdown();

        try {
            if (!executors.awaitTermination(EXECUTOR_AWAIT_TERMINATION, TimeUnit.SECONDS)) {
                log.warn("Executor didn't stop correctly, shutdownNow");
                executors.shutdownNow();
            } else {
                log.info("Executor stopped correctly");
            }
        } catch (InterruptedException e) {
            log.warn("Thread {} was interrupted", Thread.currentThread().getName());
            Thread.currentThread().interrupt();
        }
    }
}
