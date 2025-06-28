package school.faang.downloading_alchemy;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class PotionGathering {
    public static void main(String[] args) {
        List<Potion> potions = List.of(
                new Potion("Healing Potion", 5),
                new Potion("Mana Potion", 3),
                new Potion("Stamina Potion", 4)
        );
        gatherAllIngredients(potions);
    }

    public static void gatherAllIngredients(List<Potion> potions) {
        List<CompletableFuture<Integer>> futures = potions.stream()
                .map(PotionGathering::gatherIngredients)
                .toList();
        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();
        int total = futures.stream()
                .mapToInt(CompletableFuture::join)
                .sum();
        System.out.println("Всего нужно ингредиентов: " + total);
    }

    private static CompletableFuture<Integer> gatherIngredients(Potion potion) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
            return potion.getRequiredIngredients();
        });
    }
}