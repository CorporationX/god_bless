package faang.school.godbless.Task_Leveling_Alchemy;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;


public class PotionMaker {

    public static int gatherIngredients(Potion potion) throws ExecutionException, InterruptedException {
        ExecutorService potionService = Executors.newFixedThreadPool(potion.getRequiredIngredients());
        List<CompletableFuture<Void>> futures = new ArrayList<>();
        for (int i = 0; i < potion.getRequiredIngredients(); i++) {
            int index = i;
            CompletableFuture<Void> numberOfIngredients = CompletableFuture.runAsync(() -> {
                System.out.println("creating potion number " + index);
                try {
                    Thread.sleep(2000L);
                } catch (InterruptedException e) {
                    throw new RuntimeException("the potion was not made...");
                }
            }, potionService);
            futures.add(numberOfIngredients);
        }
        potionService.shutdown();
        CompletableFuture[] futureResult = futures.toArray(new CompletableFuture[futures.size()]);
        CompletableFuture<Void> combinedResult = CompletableFuture.allOf(futureResult);
        CompletableFuture<Integer> finalResult = combinedResult.thenApply(x -> (int) futures.stream()
                .map(CompletableFuture::join).count());
        System.out.println("All potions were prepared");
        return finalResult.get();
    }

    public int gatherAllIngredients(List<Potion> potions) {
        return -1;
    }

}
