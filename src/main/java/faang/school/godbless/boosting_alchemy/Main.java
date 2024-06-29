package faang.school.godbless.boosting_alchemy;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        List<Potion> potions = List.of(
                new Potion("Potion1", 6),
                new Potion("Potion2", 4),
                new Potion("Potion3", 5),
                new Potion("Potion4", 2),
                new Potion("Potion5", 7),
                new Potion("Potion6", 12),
                new Potion("Potion7", 8),
                new Potion("Potion8", 9),
                new Potion("Potion9", 1),
                new Potion("Potion10", 12));

        PotionCollectService potionCollectService = new PotionCollectService(new AtomicInteger(0));

        CompletableFuture<Void>[] completableFutures = new CompletableFuture[potions.size()];

        for (int i = 0; i < completableFutures.length; i++) {
            completableFutures[i] = potionCollectService
                    .gatherIngredients(potions.get(i), executorService)
                    .thenAccept(result -> potionCollectService.getTotalIngredients().addAndGet(result));
        }

        CompletableFuture<Void> combinedFuture = CompletableFuture.allOf(completableFutures);

        try {
            combinedFuture.get();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }

        executorService.shutdown();

        System.out.println("Total ingredients: " + potionCollectService.getTotalIngredients());
    }
}
