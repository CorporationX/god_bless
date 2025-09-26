package school.faang.bjs2_94944;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class PotionGathering {
    private static final int THREAD_COUNT = 5;

    public int gatherIngredients(Potion potion) {
        try {
            System.out.printf("Gathering ingredients for potion %s\n", potion.name());
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.err.printf("Gathering ingredients was interrupted for potion %s\n", potion.name());
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
        System.out.printf("Gathered %d ingredients for potion %s\n", potion.requiredIngredients(), potion.name());
        return potion.requiredIngredients();
    }

    public void gatherAllIngredients(List<Potion> potions) {
        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_COUNT);
        List<CompletableFuture<Integer>> futures = potions.stream()
                .map(potion ->
                        CompletableFuture.supplyAsync(() -> gatherIngredients(potion), executorService)
                                .orTimeout(2L, TimeUnit.SECONDS)
                                .exceptionally(ex -> {
                                    System.out.printf("Error while gathering ingredients for potion %s, %s\n",
                                            potion.name(),
                                            ex.toString());
                                    return 0;
                                })
                ).toList();

        CompletableFuture<Void> allFinished = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));
        CompletableFuture<Integer> totalIngredientsFuture = allFinished.thenApply(future -> futures.stream()
                .map(CompletableFuture::join)
                .reduce(0, Integer::sum));

        int totalIngredients = totalIngredientsFuture.join();
        System.out.printf("Gathered ingredients count: %d\n", totalIngredients);
        executorService.shutdown();
    }
}
