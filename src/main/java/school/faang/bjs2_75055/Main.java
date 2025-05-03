package school.faang.bjs2_75055;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {

    private static final int THREAD_WAITING_TIME = 2;
    private static final int TIMEOUT_IN_SEC = 3;
    private static final ExecutorService POOL = Executors.newCachedThreadPool();

    public static void main(String[] args) {
        List<Potion> potions = List.of(
                new Potion("Healing Potion", 5),
                new Potion("Mana Potion", 3),
                new Potion("Stamina Potion", 4)
        );

        gatherAllIngredients(potions);
    }

    private static void gatherAllIngredients(List<Potion> potions) {
        List<CompletableFuture<Integer>> gatheredIngredients = potions.stream()
                .map(potion ->
                        CompletableFuture.supplyAsync(() -> gatherIngredients(potion), POOL))
                .toList();

        CompletableFuture<Void> completed = CompletableFuture.allOf(
                gatheredIngredients.toArray(new CompletableFuture[0]));

        int integerResult = completed.thenApply(v ->
                gatheredIngredients.stream()
                        .map(CompletableFuture::join)
                        .reduce(0, Integer::sum)).join();

        log.info("Final result -> {}", integerResult);

        terminateExecutor();
    }

    private static int gatherIngredients(Potion potion) {
        try {
            TimeUnit.SECONDS.sleep(TIMEOUT_IN_SEC);

            return potion.getRequiredIngredients();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }

    private static void terminateExecutor() {
        POOL.shutdown();

        try {
            if (!POOL.awaitTermination(THREAD_WAITING_TIME, TimeUnit.MINUTES)) {
                POOL.shutdownNow();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }
}
