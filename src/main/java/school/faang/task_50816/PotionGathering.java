package school.faang.task_50816;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;

@Slf4j
@RequiredArgsConstructor
public class PotionGathering {
    private final ExecutorService executorService;

    public CompletableFuture<Integer> gatherAllIngredientsAsync(List<Potion> potions) {
        CompletableFuture<?>[] tasks = potions.stream()
                .map(potion -> CompletableFuture.supplyAsync(() -> {
                    log.info("Начат сбор ингредиентов для: {}", potion.getName());
                    try {
                        Thread.sleep((long) potion.getRequiredIngredients()
                                * Constants.TASK_DELAY_MULTIPLIER.getValue());
                    } catch (InterruptedException e) {
                        log.error("Ошибка при сборе ингредиентов для {}: {}", potion.getName(), e.getMessage());
                    }
                    log.info("Завершён сбор ингредиентов для: {}", potion.getName());
                    return potion.getRequiredIngredients();
                }, executorService))
                .toArray(CompletableFuture[]::new);

        return CompletableFuture.allOf(tasks)
                .thenApply(v -> potions.stream()
                        .mapToInt(Potion::getRequiredIngredients)
                        .sum());
    }
}