package faang.school.godbless.UpgradingAlchemy;

import lombok.Getter;

import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

@Getter
public class GatheringIngredients {
    private static final int NUM_THREADS = 3;
    private static final ExecutorService EXECUTOR = Executors.newFixedThreadPool(NUM_THREADS);
    private static final Random random = new Random();
    private final AtomicInteger numOfAllIngredients = new AtomicInteger(0);

    public int gatheringIngredients(Potion potion) {
        potion.getRequiredIngredients().forEach((ingredient) -> {
            try {
                Thread.sleep((long) random.nextInt(1000) * potion.getRequiredIngredients().size());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        return potion.getRequiredIngredients().size();
    }

    public void allIngredientsCalculator(List<Potion> potions) {
        List<CompletableFuture<Void>> allPotionsFuturesList = potions.stream()
                .map(potion -> CompletableFuture.runAsync(() -> numOfAllIngredients.addAndGet(gatheringIngredients(potion))))
                        .toList();
        CompletableFuture<Void> allPotionsFuture = CompletableFuture.allOf(allPotionsFuturesList.toArray(new CompletableFuture[0]));
        allPotionsFuture.join();
    }

    public void shutdownGatherIngredients() {
        EXECUTOR.shutdown();
    }
}
