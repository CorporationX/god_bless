package school.faang.alchemy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
@AllArgsConstructor
@Data
public class Potion {
    private final String name;
    private int requiredIngredients;
    private static final int GATHERING_TIME = 3000;

    private static final AtomicInteger totalIngredients = new AtomicInteger(0);


    public CompletableFuture<Integer> gatherIngredients() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(GATHERING_TIME);
            } catch (InterruptedException e) {
                log.error("Ошибка при сборе ингредиентов для зелья {}", name, e);
                Thread.currentThread().interrupt();
                throw new RuntimeException(e.getMessage(), e);
            }
            return requiredIngredients;
        });
    }

    public static CompletableFuture<Integer> gatherAllIngredients(List<Potion> potions) {
        List<CompletableFuture<Integer>> futures = potions.stream()
                .map(Potion::gatherIngredients)
                .toList();



        CompletableFuture<Void> allOf = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));

        return allOf.thenApply(v -> futures.stream()
                .map(CompletableFuture::join)
                .mapToInt(totalIngredients::addAndGet)
                .sum());
    }
}
