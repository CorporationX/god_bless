package school.faang.Sprints.Multithreading_Async.downloading_alchemy;

import lombok.NonNull;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

public class PotionService {

    public static void gatherAllIngredients(@NonNull List<Potion> potions) {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        List<CompletableFuture<Integer>> completableFutures = potions.stream()
                .map(potion -> CompletableFuture.supplyAsync(() -> ThreadGatherIngredients(potion), executor))
                .collect(Collectors.toList());
        CompletableFuture<Void> allFutures = CompletableFuture.allOf(completableFutures.toArray(new CompletableFuture[0]));

        allFutures.thenRun(() -> sumAllIngredients(completableFutures)).join();
        executor.shutdown();
    }

    private static int gatherIngredients(Potion potion) {
        try {
            Thread.sleep(3_000);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
        return potion.getRequiredIngredients();
    }

    private static int ThreadGatherIngredients(Potion potion){
        System.out.println(Thread.currentThread().getName());
        return gatherIngredients(potion);
    }

    private static void sumAllIngredients(@NonNull List<CompletableFuture<Integer>> completableFutures){
        int result = completableFutures.stream()
                .mapToInt(future -> {
                    try {
                        return future.get();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    } catch (ExecutionException e) {
                        throw new RuntimeException(e);
                    }
                })
                .sum();
        System.out.println(result);
    }
}
