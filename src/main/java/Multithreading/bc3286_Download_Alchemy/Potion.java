package Multithreading.bc3286_Download_Alchemy;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@AllArgsConstructor
@Data
public class Potion {
    private String name;
    private int requiredIngredients;

    public CompletableFuture<Integer> gatherIngredients(Potion potion) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        CompletableFuture<Integer> countIngredients = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(100L * requiredIngredients);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return potion.getRequiredIngredients();
        }, executorService);

        executorService.shutdown();

        return countIngredients;
    }
}
