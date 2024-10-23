package school.faang.alchemy;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class PotionCollectionService {
    public static final int TIME_TO_COLLECT_INGREDIENTS = 2000;
    public static final ExecutorService executor = Executors.newFixedThreadPool(5);
    private AtomicInteger totalAmountOfIngredients = new AtomicInteger(0);

    public int gatherIngredients(Potion potion) {
        try {
            Thread.sleep(TIME_TO_COLLECT_INGREDIENTS);
        } catch (InterruptedException e) {
            e.printStackTrace();
            log.error("The thread was interrupted during sleep: {}", e);
        }
        return potion.getRequiredIngredients();
    }

    public void gatherAllIngredients(List<Potion> potions) {
        List<CompletableFuture<Integer>> allIngredients = potions.stream()
                .map(potion -> CompletableFuture.supplyAsync(() -> gatherIngredients(potion), executor))
                .toList();
        CompletableFuture<Void> allTasks = CompletableFuture.allOf(allIngredients.toArray(CompletableFuture[]::new));
        allTasks.thenRun(() -> {
            int amountOfIngredients = allIngredients.stream()
                    .map(CompletableFuture::join)
                    .mapToInt(Integer::intValue)
                    .sum();
            addIngredients(amountOfIngredients);
            log.info("Total number of ingredients collected: {}", totalAmountOfIngredients);
        });
    }

    public void addIngredients(int amount) {
        totalAmountOfIngredients.addAndGet(amount);
    }

    public void executorShutdown() {
        executor.shutdown();
    }
}
