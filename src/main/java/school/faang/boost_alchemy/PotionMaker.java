package school.faang.boost_alchemy;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class PotionMaker {
    private static final long THREAD_SLEEP_TIME = 1000L;
    @Getter
    private final AtomicInteger totalIngredients = new AtomicInteger(0);
    private final ExecutorService executor = Executors.newFixedThreadPool(5);

    public void countAllIngredients(List<Potion> potions) {
        potions.stream()
                .map(this::gatherIngredients)
                .peek()
                .forEach(ingredients -> totalIngredients.addAndGet(ingredients.join()));
    }

    private CompletableFuture<Integer> gatherIngredients(Potion potion) {
        return CompletableFuture.supplyAsync(() -> {
            takeTimeForGathering();
            log.info("Potion {} counted", potion.getName());
            return potion.getRequiredIngredients();
        }, executor);
    }

    private void takeTimeForGathering() {
        try {
            Thread.sleep((long) (THREAD_SLEEP_TIME * (Math.random() + 0.1)));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("Thread {} error", Thread.currentThread().getName());
        }
    }
}