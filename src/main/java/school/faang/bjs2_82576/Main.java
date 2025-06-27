package school.faang.bjs2_82576;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        List<Potion> potions = List.of(
                new Potion("Healing Potion", 5),
                new Potion("Mana Potion", 3),
                new Potion("Stamina Potion", 4)
        );

        ExecutorService executor = Executors.newFixedThreadPool(4);
        PotionService potionService = new PotionService(executor);

        List<CompletableFuture<Integer>> futurePotions = potions.stream()
                .map(potionService::collectIngredients)
                .toList();

        CompletableFuture<Void> allDone = CompletableFuture.allOf(
                futurePotions.toArray(new CompletableFuture[0])
        );
        allDone.join();

        int total = futurePotions.stream()
                .map(CompletableFuture::join)
                .mapToInt(Integer::intValue)
                .sum();

        System.out.println("Total ingredients collected: " + total);

        executor.shutdown();
    }
}
