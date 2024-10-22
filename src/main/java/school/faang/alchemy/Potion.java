package school.faang.alchemy;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@AllArgsConstructor
@Getter
public class Potion {
    private final String name;
    private final int requiredIngredients;

    public CompletableFuture<Integer> gatherIngredients() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(requiredIngredients * 1000L);
                return requiredIngredients;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }

    public static List<CompletableFuture<Integer>> gatherAllIngredients(List<Potion> potions) {
        return potions.stream()
                .map(Potion::gatherIngredients)
                .toList();
    }
}
