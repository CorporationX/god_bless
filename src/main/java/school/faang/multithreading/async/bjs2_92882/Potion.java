package school.faang.multithreading.async.bjs2_92882;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Slf4j
@AllArgsConstructor
@Getter
public class Potion {
    private static final long DELAY_GATHER = 2000; //2 секунды
    private String name;
    private int numberIngredients;

    private int getRequiredIngredients() {
        log.info("Сбор ингредиентов для '{}' закончен, из количество: {}", getName(), getNumberIngredients());
        return getNumberIngredients();
    }

    private static CompletableFuture<Integer> gatherIngredients(Potion potion) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                log.info("Начинаем сбор ингредиентов для зелья '{}'", potion.getName());
                Thread.sleep(DELAY_GATHER);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
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
