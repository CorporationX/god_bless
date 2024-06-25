package faang.school.godbless.multithreading_async.task_6;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class PotionIngredientCollector {
    private final AtomicInteger sumOfIngredients = new AtomicInteger(0);

    private static final Random RANDOM = new Random();
    private static final int MIN_GATHERING_INGREDIENTS_DURATION = 1000;
    private static final int MAX_GATHERING_INGREDIENTS_DURATION = 5000;

    private void gatherIngredients(Potion potion) {
        try {
            Thread.sleep(RANDOM.nextInt(MIN_GATHERING_INGREDIENTS_DURATION, MAX_GATHERING_INGREDIENTS_DURATION));
        } catch (InterruptedException e) {
            log.error("Thread was interrupted while gathering ingredients for potion: {}", potion.name(), e);
        }
        sumOfIngredients.addAndGet(potion.requiredIngredients());
    }

    public void gatherAllIngredients(List<Potion> potions, ExecutorService executor) {
        final List<CompletableFuture<Void>> completableFutures = potions.stream()
                .map(potion -> CompletableFuture.runAsync(() -> gatherIngredients(potion), executor))
                .toList();
        final CompletableFuture<Void> allFutures = CompletableFuture.allOf(completableFutures.toArray(new CompletableFuture[0]));
        allFutures.join();
        log.info("Sum of ingredients: {}", sumOfIngredients.get());
    }
}
