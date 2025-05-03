package school.faang.alchemy;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@Slf4j
public class PotionGathering {
    private static final int FIVE_SECONDS_IN_MS = 5_000;
    private static final int MAX_WAIT_MINUTES = 1;
    private static final ExecutorService potionExecutor = Executors.newCachedThreadPool();

    public static void main(String[] args) {
        List<Potion> potions = List.of(
                new Potion("Healing Potion", 5),
                new Potion("Mana Potion", 3),
                new Potion("Stamina Potion", 4)
        );

        List<CompletableFuture<Integer>> futures = gatherAllIngredients(potions);
        CompletableFuture<Void> allOf = CompletableFuture.allOf(futures.toArray(CompletableFuture[]::new));
        CompletableFuture<Integer> totalFuture = allOf.thenApply(v ->
                futures.stream()
                        .map(CompletableFuture::join)
                        .reduce(0, Integer::sum)
        );

        try {
            int totalIngredients = totalFuture.get(MAX_WAIT_MINUTES, TimeUnit.MINUTES);
            log.info("Общее количество ингредиентов: {}", totalIngredients);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            log.error("Ошибка при ожидании сбора ингредиентов", e);
        } finally {
            shutdown();
        }
    }

    static List<CompletableFuture<Integer>> gatherAllIngredients(List<Potion> potions) {
        return potions.stream()
                .map(potion -> CompletableFuture.supplyAsync(() -> gatherIngredients(potion), potionExecutor))
                .toList();
    }

    private static Integer gatherIngredients(Potion potion) {
        log.info("Собираем ингредиенты для зелья {}...", potion.getName());
        try {
            Thread.sleep(FIVE_SECONDS_IN_MS);
        } catch (InterruptedException e) {
            log.error("Операция прервана");
            Thread.currentThread().interrupt();
        }
        log.info("Ингредиенты для зелья {} собраны {}", potion.getName(), potion.getRequiredIngredients());
        return potion.getRequiredIngredients();
    }

    private static void shutdown() {
        potionExecutor.shutdown();
        try {
            if (!potionExecutor.awaitTermination(MAX_WAIT_MINUTES, TimeUnit.MINUTES)) {
                log.info("Not all tasks are completed in {} minutes. Attempting to force stop", MAX_WAIT_MINUTES);
                potionExecutor.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("Waiting for threads to finish is interrupted.");
            potionExecutor.shutdownNow();
        }
    }
}
