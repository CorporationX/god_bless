package school.faang.bjs2_82667;

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
        ExecutorService executor = Executors.newFixedThreadPool(5);
        PotionService potionService = new PotionService(executor);

        List<CompletableFuture<Integer>> ingridietnsFuture = potions.stream()
                .map(potion -> potionService.collectIngridients(potion))
                .toList();

        CompletableFuture<Void> allDone = CompletableFuture
                .allOf(ingridietnsFuture.toArray(new CompletableFuture[0])
                );
        allDone.join();

        int result = ingridietnsFuture.stream()
                .map(CompletableFuture::join)
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println("Общее количество собранных ингредиентов: " + result);
        executor.shutdown();
    }
}
