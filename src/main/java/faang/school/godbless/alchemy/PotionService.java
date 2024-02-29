package faang.school.godbless.alchemy;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class PotionService {

    private final ExecutorService EXECUTOR_SERVICE = Executors.newCachedThreadPool();
    private List<Potion> potions;

    public PotionService(List<Potion> potions) {
        this.potions = potions;
    }

    public int gatherAllIngredients() {
        List<CompletableFuture<Integer>> gatheredIngredients = potions.stream()
                .map(potion -> CompletableFuture.supplyAsync(() -> gatherIngredients(potion), EXECUTOR_SERVICE))
                .toList();
        CompletableFuture.allOf(gatheredIngredients.toArray(CompletableFuture[]::new)).join();

        return gatheredIngredients.stream()
                .mapToInt(this::futureGet)
                .sum();
    }

    public void shutdownAndAwaitExecutor() {
        EXECUTOR_SERVICE.shutdown();
        awaitTermination(5L);
    }

    private <T> T futureGet(Future<T> future) {
        try {
            return future.get(30L, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        } catch (ExecutionException | TimeoutException e) {
            throw new RuntimeException(e);
        }
    }

    private int gatherIngredients(Potion potion) {
        sleep(3L);
        return potion.getIngredientsCount();
    }

    private void awaitTermination(Long minutes) {
        try {
            EXECUTOR_SERVICE.awaitTermination(minutes, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private void sleep(Long seconds) {
        try {
            Thread.sleep(seconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
