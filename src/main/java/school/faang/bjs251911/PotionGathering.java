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
import java.util.concurrent.TimeUnit;

@Slf4j
public class PotionGathering {

    public static final int TIME_PROCESS = 10;
    public static final int REQUIRED_INGREDIENTS = 2;
    public static final int NUMBER_POTIONS = 500;
    public static final int NUMBER_THREADS = 10;
    public static final ExecutorService executor = Executors.newFixedThreadPool(NUMBER_THREADS);
    private static final long TIME_DELAY_FINISH = 60;

    public static void main(String[] args) {
        List<Potion> potions = createPotions();

        val total = gatherIngredients(potions);
        log.info("Общее количество собранных ингредиентов: {}", total);
    }

    private static int gatherIngredients(List<Potion> potions) {
        return calcIngredients(potions);
    }

    private static int calcIngredients(List<Potion> potions) {
        try {
            List<CompletableFuture<Integer>> futures = potions.stream()
                    .map(potion -> CompletableFuture.supplyAsync(potion::getRequiredIngredients,
                            PotionGathering.executor))
                    .toList();

            CompletableFuture<Void> allDoneFuture = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));

            return allDoneFuture.thenApply(v ->
                    futures.stream()
                            .mapToInt(PotionGathering::getIngredients)
                            .sum()
            ).join();
        } finally {
            PotionGathering.executor.shutdown();
            try {
                if (!executor.awaitTermination(TIME_DELAY_FINISH, TimeUnit.SECONDS)) {
                    System.out.println("Принудительное завершение пула потоков.");
                    executor.shutdownNow();
                }
            } catch (InterruptedException ex) {
                executor.shutdownNow();
                log.error("Everything is bad! {}", String.valueOf(ex));
            }
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
