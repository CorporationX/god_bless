package school.faang.bjs251911;

import lombok.extern.slf4j.Slf4j;
import lombok.val;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

@Slf4j
public class PotionGathering {

    public static final int TIME_PROCESS = 10;
    public static final int REQUIRED_INGREDIENTS = 2;
    public static final int NUMBER_POTIONS = 500;
    public static final int NUMBER_THREADS = 10;

    public static void main(String[] args) {

        List<Potion> potions = createPotions();

        val total = gatherIngredients(potions);
        log.info("Общее количество собранных ингредиентов: {}", total);
    }

    private static int gatherIngredients(List<Potion> potions) {
        ExecutorService executor = Executors.newFixedThreadPool(NUMBER_THREADS);
        return calcIngredients(potions, executor);
    }

    private static int calcIngredients(List<Potion> potions, ExecutorService executor) {
        try {
            List<CompletableFuture<Integer>> futures = potions.stream()
                    .map(potion -> CompletableFuture.supplyAsync(potion::getRequiredIngredients, executor))
                    .toList();

            CompletableFuture<Void> allDoneFuture = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));

            return allDoneFuture.thenApply(v ->
                    futures.stream()
                            .mapToInt(PotionGathering::getIngredients)
                            .sum()
            ).join();
        } finally {
            executor.shutdown();
        }
    }

    private static int getIngredients(CompletableFuture<Integer> future) {
        try {
            Thread.sleep(TIME_PROCESS);
            return future.get();
        } catch (InterruptedException | ExecutionException ex) {
            log.error("The task has been aborted!{}", String.valueOf(ex));
            Thread.currentThread().interrupt();
            throw new RuntimeException(ex);
        }
    }

    private static List<Potion> createPotions() {
        List<Potion> potions = new ArrayList<>();
        IntStream.range(0, NUMBER_POTIONS).forEach(num ->
                potions.add(new Potion("Potion № " + num, REQUIRED_INGREDIENTS)));
        return potions;
    }
}
