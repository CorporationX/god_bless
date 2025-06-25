package school.faang.bjs2_82576;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        List<Potion> potions = List.of(
                new Potion("Healing Potion", 5),
                new Potion("Mana Potion", 3),
                new Potion("Stamina Potion", 4)
        );

        PotionService potionService = new PotionService();

        List<CompletableFuture<Integer>> futurePotions = potions.stream()
                .map(potionService::collectIngredients)
                .toList();

        CompletableFuture<Void> allDone = CompletableFuture.allOf(
                futurePotions.toArray(new CompletableFuture[0])
        );
        allDone.join();

        List<Integer> results = futurePotions.stream()
                .map(CompletableFuture::join)
                .toList();

        int total = results.stream()
                .mapToInt(Integer::intValue)
                .sum();

        System.out.println("Total ingredients collected: " + total);

        potionService.shutdown();
    }
}
