package bjs262450;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Slf4j
public class Potion {
    private static final long THREAD_SLEEP_MULTIPLIER_IN_MS = 1000;
    private static final ExecutorService EXECUTOR_SERVICE = Executors.newFixedThreadPool(2);
    private String name;
    private int requiredIngredients;
    private final List<Potion> potions = new ArrayList<>();

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
        }, EXECUTOR_SERVICE).handle((result, exception) -> {
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
                        ingredientsNumberCf = potion.gatherIngredients(potion);
                    } catch (InterruptedException e) {
                        log.error("{} interrupted", Thread.currentThread().getId(),
                                new AlchemyException("Interrupted exception", e));
                        Thread.currentThread().interrupt();
                    }
                    return ingredientsNumberCf;
                }).toList();
    }

    public AtomicInteger calculateIngredients(@NonNull List<Potion> potions) {
        List<CompletableFuture<Integer>> ingredientsNumberCf = gatherAllIngredients(potions);
        validateIngredientsCompletableFuture(ingredientsNumberCf);
        AtomicInteger ingredientsNumber = new AtomicInteger(0);
        ingredientsNumberCf.forEach(ingredientNumberCF -> ingredientNumberCF.thenApply(ingredientsNumber::addAndGet));
        return ingredientsNumber;
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

    private void validateIngredientsCompletableFuture(List<CompletableFuture<Integer>> ingredientsNumberCf) {
        if (ingredientsNumberCf.isEmpty()) {
            throw new AlchemyException("Potions completable future can not be empty",
                    new IllegalArgumentException());
        }
    }
}
