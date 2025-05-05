package school.faang.stream4.alchemyleveling;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class PotionGathering {
    public static final int SLEEPING_TIME = 2000;

    public static CompletableFuture<Integer> gatherIngredients(Potion potion, ExecutorService pool) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(SLEEPING_TIME);
                return potion.getRequiredIngredients();
            } catch (InterruptedException e) {
                log.error(e.getMessage());
                return 0;
            }
        }, pool);
    }

    public static CompletableFuture<Integer> gatherAllIngredients(List<Potion> potions, ExecutorService pool) {
        List<CompletableFuture<Integer>> futures =
                potions.stream()
                        .map(potion -> PotionGathering.gatherIngredients(potion, pool))
                        .toList();

        return CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]))
                .thenApply(v -> futures.stream()
                        .mapToInt(CompletableFuture::join)
                        .sum());
    }


    public static void main(String[] args) {
        List<Potion> potions = List.of(
                new Potion("Healing Potion", 5),
                new Potion("Mana Potion", 3),
                new Potion("Stamina Potion", 4),
                new Potion("Agility Potion", 5)
        );

        ExecutorService pool = Executors.newCachedThreadPool();

        gatherAllIngredients(potions, pool)
                .thenAcceptAsync(result ->
                        System.out.printf("Общее количество собранных ингредиентов: %d", result))
                .join();

        pool.shutdown();

        try {
            if (!pool.awaitTermination(SLEEPING_TIME, TimeUnit.MILLISECONDS)) {
                pool.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("Завершение пула потоков прервано ", e);
            pool.shutdownNow();
        }
    }
}
