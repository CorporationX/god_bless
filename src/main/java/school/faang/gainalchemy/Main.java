package school.faang.gainalchemy;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        List<Potion> potions = List.of(
                new Potion("Healing Potion", 5),
                new Potion("Mana Potion", 3),
                new Potion("Stamina Potion", 4)
        );

        List<CompletableFuture<Integer>> ingridients = potions.stream()
                .map(potion -> CompletableFuture.supplyAsync(() -> Potion.gatherAllIngredients(potion), executorService))
                .toList();

        CompletableFuture
                .allOf(ingridients.toArray(new CompletableFuture[0]))
                .thenRun(() -> {
                    int totalIngredients = ingridients.stream()
                            .map(CompletableFuture::join)
                            .mapToInt(Integer::intValue).sum();
                    System.out.println("Общее количество ингридиентов: " + totalIngredients);
        });

        executorService.shutdown();
    }
}
