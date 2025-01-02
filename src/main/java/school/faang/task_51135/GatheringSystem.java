package school.faang.task_51135;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicInteger;

public class GatheringSystem {
    private final AtomicInteger totalIngredients = new AtomicInteger(0);

    public CompletableFuture<Integer> gatherIngredients(Potion potion) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            return potion.getRequiredIngredients();
        });
    }

    public void gatherAllIngredients(List<Potion> potions) {
        List<CompletableFuture<Integer>> futures = potions.stream()
                .map(this::gatherIngredients)
                .toList();

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]))
                .thenRun(() -> {
                    futures.forEach(future -> {
                        try {
                            totalIngredients.addAndGet(future.get());
                        } catch (InterruptedException | ExecutionException e) {
                            Thread.currentThread().interrupt();
                        }
                    });
                    System.out.println("Total amount of gathered ingredients: "
                            + totalIngredients.get());
                }).join();
    }
}