package school.faang.task_62565;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class PotionGathering {
    public static void gatherAllIngredients(List<Potion> potions) {
        List<CompletableFuture<Integer>> futures = potions.stream()
                .map(PotionGathering::gatherIngredients)
                .toList();

        CompletableFuture<Void> allOf =
                CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));

        allOf.thenRun(() -> {
            int totalIngredients = futures.stream()
                    .mapToInt(CompletableFuture::join)
                    .sum();
            System.out.println("Общее количество собранных ингредиентов: "
                    + totalIngredients);
        });

        allOf.join();
    }

    private static CompletableFuture<Integer> gatherIngredients(Potion potion) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(potion.getRequiredIngredients() * 1000L); // Имитируем сбор ингредиентов
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
            return potion.getRequiredIngredients(); // Возвращаем количество собранных ингредиентов
        });
    }

    public static void main(String[] args) {
        List<Potion> potions = List.of(
                new Potion("Healing Potion", 5),
                new Potion("Mana Potion", 3),
                new Potion("Stamina Potion", 4)
        );

        gatherAllIngredients(potions);
    }
}
