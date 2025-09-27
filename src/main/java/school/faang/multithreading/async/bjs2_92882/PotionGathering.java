package school.faang.multithreading.async.bjs2_92882;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Slf4j
@AllArgsConstructor
@Getter
public class PotionGathering {
    private static final long DELAY_GATHER = 2000; //2 секунды

    private static CompletableFuture<Integer> gatherIngredients(Potion potion) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                log.info("Начинаем сбор ингредиентов для зелья '{}'", potion.name());
                Thread.sleep(DELAY_GATHER);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException("Ошибка при сборе ингредиентов для: " + potion.name(), e);
            }
            return potion.getRequiredIngredients();
        });
    }

    public static void gatherAllIngredients(List<Potion> potions) {
        List<CompletableFuture<Integer>> futures = potions.stream()
                .map(potion -> gatherIngredients(potion))
                .toList();

        CompletableFuture<Void> allFutures = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));

        int totalSum = allFutures
                .thenApply(v -> futures.stream()
                        .map(CompletableFuture::join)
                        .mapToInt(Integer::intValue)
                        .sum())
                .join();
        log.info("Общая сумма всех собранных ингредиентов: {}", totalSum);
    }
}
