package school.faang.sprint4.task50950;

import lombok.extern.slf4j.Slf4j;
import school.faang.sprint4.task50950.model.Potion;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Slf4j
public class Main {
    private static final int INGREDIENTS_AMORTENTION = 5;
    private static final int INGREDIENTS_MOPSUS = 20;
    private static final int INGREDIENTS_INVISIBLE = 30;
    private static final int TIME_TO_GATHER_MSEC = 1000;

    public static void main(String[] args) {
        List<Potion> potions = List.of(
                new Potion("Amortention", INGREDIENTS_AMORTENTION),
                new Potion("Mopsus", INGREDIENTS_MOPSUS),
                new Potion("Invisible", INGREDIENTS_INVISIBLE)
        );
        gatherAllIngredients(potions);
    }

    private static void gatherAllIngredients(List<Potion> potions) {
        int gotheredIngredients;
        List<CompletableFuture<Integer>> gotheredResults;
        int needToGatherQuantity;
        do {
            gotheredResults = potions.stream()
                    .map(Main::gatherIngredients)
                    .toList();
            CompletableFuture all = CompletableFuture.allOf((CompletableFuture<Integer>) gotheredResults.toArray()[0]);

            try {
                all.get();
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }
            needToGatherQuantity = potions.stream().mapToInt(Potion::getRequiredIngredients).sum();
        } while (needToGatherQuantity > 0);

        gotheredIngredients = potions.stream().mapToInt(Potion::getCapacity).sum();
        log.info("Work complete! Collected {} of ingredients", gotheredIngredients);
    }

    private static CompletableFuture<Integer> gatherIngredients(Potion potion) {
        return CompletableFuture.supplyAsync(() -> {
            int numOfRequiredIngredients = potion.getRequiredIngredients();
            if (numOfRequiredIngredients > 0) {
                numOfRequiredIngredients = potion.decrementAndGetRequiredIngredients();
                try {
                    Thread.sleep(TIME_TO_GATHER_MSEC);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                log.info("An ingredient for potion {} is collected, need to collect: {}",
                        potion.getName(),
                        numOfRequiredIngredients);
            } else {
                log.info("All ingredients for potion {} are collected", potion.getName());
            }
            return numOfRequiredIngredients;
        });
    }
}
