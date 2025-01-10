package school.faang.task_51135;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class GatheringSystem {
    private final AtomicInteger totalIngredients = new AtomicInteger(0);
    final ExecutorService executorService = Executors.newFixedThreadPool(3);

    public void gatherAllIngredients(List<Potion> potions) {
        List<CompletableFuture<Integer>> futures = potions.stream()
                .map(potion -> CompletableFuture.supplyAsync(() -> gatherIngredients(potion), executorService)
                        .thenApply(totalIngredients::addAndGet))
                .toList();

        CompletableFuture<Void> all = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));
        all.join();
        System.out.println("Total amount of gathered ingredients: " + totalIngredients.get());
        executorService.shutdown();
    }

    private int gatherIngredients(Potion potion) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return potion.requiredIngredients();
    }
}