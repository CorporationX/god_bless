package faang.school.godbless.Task_Leveling_Alchemy;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class PotionMaker {

    private static final ExecutorService executor = Executors.newFixedThreadPool(3);

    public static int gatherIngredients(Potion potion) {
        System.out.println("the ingredients for " + potion.getName() + " are being prepared...");
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            throw new RuntimeException("the ingredients haven't been gathered...");
        }
        System.out.println("the ingredients for " + potion.getName() + " are ready");
        return potion.getRequiredIngredients();
    }

    public static int gatherAllIngredients(List<Potion> potions) {
        AtomicInteger numberOfPotions = new AtomicInteger(0);
        CompletableFuture<Void> allPotions = CompletableFuture.allOf(potions.stream().
                map(potion -> CompletableFuture.supplyAsync(() -> gatherIngredients(potion), executor)
                        .thenAccept(numberOfPotions::addAndGet)).toArray(CompletableFuture[]::new));
        allPotions.join();
        executor.shutdown();
        return numberOfPotions.get();
    }

}
