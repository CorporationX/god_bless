package bjs262450;

import lombok.Getter;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@Getter
@Slf4j
public class PotionService {
    private static final long THREAD_SLEEP_MULTIPLIER_IN_MS = 1000;
    private final ExecutorService executorService = Executors.newFixedThreadPool(2);
    private final AtomicInteger ingredientsNumber = new AtomicInteger(0);

    public CompletableFuture<Integer> gatherIngredients(@NonNull Potion potion) throws InterruptedException {
        validatePotion(potion);
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(THREAD_SLEEP_MULTIPLIER_IN_MS);
            } catch (InterruptedException e) {
                log.error("{} interrupted", Thread.currentThread().getId(),
                        new AlchemyException("InterruptedException", e.getCause()));
                Thread.currentThread().interrupt();
            }
            return potion.getRequiredIngredients();
        }, executorService).handle((result, exception) -> {
            if (result == 0) {
                log.error("{}", Thread.currentThread().getId(),
                        new AlchemyException("Result can not contains 0 ingredients"));
            }
            return result;
        });
    }

    public List<CompletableFuture<Integer>> gatherAllIngredients(@NonNull List<Potion> potions) {
        validatePotionList(potions);
        return potions.stream()
                .map(potion -> {
                    CompletableFuture<Integer> ingredientsNumberCf = null;
                    try {
                        ingredientsNumberCf = gatherIngredients(potion);
                        ingredientsNumber.getAndAdd(potion.getRequiredIngredients());
                    } catch (InterruptedException e) {
                        log.error("{} interrupted", Thread.currentThread().getId(),
                                new AlchemyException("Interrupted exception", e));
                        Thread.currentThread().interrupt();
                    }
                    return ingredientsNumberCf;
                }).toList();
    }

    private void validatePotion(Potion potion) {
        if (potion.getName().isBlank()) {
            throw new AlchemyException("Potion`s name can not be null or empty", new IllegalArgumentException());
        }
        if (potion.getRequiredIngredients() == 0) {
            throw new AlchemyException("Potion`s required ingredients can not be 0", new IllegalArgumentException());
        }
    }

    private void validatePotionList(List<Potion> potions) {
        if (potions.isEmpty()) {
            throw new AlchemyException("Potions can not be empty", new IllegalArgumentException());
        }
    }

    public void shutDownExecutorService() {
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(3000, TimeUnit.MILLISECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
        }
    }
}
