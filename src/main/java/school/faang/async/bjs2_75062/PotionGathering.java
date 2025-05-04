package school.faang.async.bjs2_75062;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static school.faang.Utils.handleExecutionException;
import static school.faang.Utils.handleInterruptedException;

@Slf4j
@RequiredArgsConstructor
public class PotionGathering {
    private final List<Potion> potions;

    public int gatherAllIngredients() {
        List<CompletableFuture<Integer>> potionsRequiredIngredients = startAsyncPortionGathering();

        waitForAllFuturesToComplete(potionsRequiredIngredients);

        int totalIngredients = sumTotalIngredients(potionsRequiredIngredients);

        log.info("Общее количество собранных ингредиентов: {}", totalIngredients);
        return totalIngredients;
    }

    private List<CompletableFuture<Integer>> startAsyncPortionGathering() {
        return this.potions.stream()
                .map(Potion::gatherIngredients)
                .toList();
    }

    private void waitForAllFuturesToComplete(List<CompletableFuture<Integer>> futures) {
        try {
            CompletableFuture.allOf(futures.toArray(new CompletableFuture[potions.size()])).get();
        } catch (InterruptedException e) {
            handleInterruptedException(e);
        } catch (ExecutionException e) {
            handleExecutionException(e);
        }
    }

    private int threadSafeGetFutureResult(CompletableFuture<Integer> future) {
        try {
            return future.get();
        } catch (InterruptedException e) {
            handleInterruptedException(e);
            return 0;
        } catch (ExecutionException e) {
            handleExecutionException(e);
            return 0;
        }
    }

    private int sumTotalIngredients(List<CompletableFuture<Integer>> futures) {
        return futures.stream()
                .mapToInt(this::threadSafeGetFutureResult)
                .sum();
    }
}
