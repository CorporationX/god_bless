package school.faang.alchemy;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class PotionGathering {

    public static void main(String[] args) {
        List<Potion> potions = List.of(
                new Potion("Healing Potion", 5),
                new Potion("Mana Potion", 3),
                new Potion("Stamina Potion", 4)
        );

        ExecutorService executor = Executors.newFixedThreadPool(potions.size());
        List<CompletableFuture<Integer>> futures = potions.stream()
                .map(potion -> CompletableFuture.supplyAsync(
                        () -> gatherAllIngredients(potion), executor))
                .toList();
        CompletableFuture<Void> allTasks =
                CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));
        allTasks.thenRun(() -> {
            int numOfCollectedIngredients = futures.stream()
                    .map(CompletableFuture::join)
                    .mapToInt(Integer::intValue)
                    .sum();
            System.out.println("Количество собранных ингредиентов " + numOfCollectedIngredients);
            executor.shutdown();
        });
    }

    public static int gatherAllIngredients(Potion potion) {
        try {
            System.out.println("Собираем ингредиенты для зелья " + potion.getName());
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            log.error(e.getMessage());
            log.error(Arrays.toString(e.getStackTrace()));
        }
        return potion.getRequiredIngredients();
    }
}
