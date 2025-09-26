package school.faang.pumping.alchemy;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Slf4j
@AllArgsConstructor
public class Potion {
    private String name;
    private Integer ingredients;

    public CompletableFuture<Integer> gatherIngredients() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000);
                log.info("Собраны ингредиенты для зелья: {}", name);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                log.error("[!] Поток прервался!");
                throw new RuntimeException(e);
            }

            return ingredients;
        });
    }

    public static void gatherAllIngredients(List<Potion> potions) {
        List<CompletableFuture<Integer>> futures = potions.stream()
                .map(Potion::gatherIngredients)
                .toList();

        CompletableFuture<Integer> totalFuture = CompletableFuture.allOf(
                futures.toArray(CompletableFuture[]::new)
        ).thenApply(v -> futures.stream()
                .map(CompletableFuture::join)
                .mapToInt(Integer::intValue)
                .sum());

        int total = totalFuture.join();

        log.info("Общее количество собранных ингредиентов: {}", total);
    }
}
