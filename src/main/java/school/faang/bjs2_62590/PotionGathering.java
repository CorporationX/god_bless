package school.faang.bjs2_62590;

import lombok.NoArgsConstructor;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@NoArgsConstructor
public class PotionGathering {

    private static final int ONE_SECOND_IN_MS = 1000;

    public CompletableFuture<Integer> gatherIngredients(Potion potion) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep((long) potion.getRequiredIngredients() * ONE_SECOND_IN_MS);
                System.out.printf("Сбор ингредиентов для зелья - %s завершен!\n", potion.getName());
            } catch (InterruptedException e) {
                System.out.println("Ошибка: " + e.getMessage());
                return 0;
            }
            return potion.getRequiredIngredients();
        });
    }

    public List<CompletableFuture<Integer>> gatherAllIngredients(List<Potion> potions) {
        return potions.stream()
                .map(this::gatherIngredients)
                .toList();
    }

}
