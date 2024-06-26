package faang.school.godbless.boosting_alchemy;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
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

        PotionCollectService potionCollectService = new PotionCollectService(potions, new AtomicInteger(0));

        List<CompletableFuture<Void>> completableFutures = new ArrayList<>();

        for (Potion potion : potionCollectService.getPotions()) {
            completableFutures.add(
                    potionCollectService
                            .gatherIngredients(potion, executorService)
                            .thenAccept(result -> potionCollectService.getTotalIngredients().addAndGet(result))
            );
        }

        for (CompletableFuture<Void> cmfs : completableFutures) {
            cmfs.join();
        }

        executorService.shutdown();

        System.out.println("Total ingredients: " + potionCollectService.getTotalIngredients());
    }
}
