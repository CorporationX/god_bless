package school.faang.task_51007;

import lombok.NonNull;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class PotionGathering {
    public static final int GATHER_TIME_MSEC = 1000;
    public static final int TIMEOUT_MIN = 1;
    public static final int THREAD_POOL_SIZE = 2;
    public static final int HEALING_POTION_QUANTITY = 5;
    public static final int MANA_POTION_QUANTITY = 3;
    public static final int STAMINA_POTION_QUANTITY = 4;
    private static ExecutorService executor;

    public static void main(String[] args) {
        List<Potion> potions = List.of(
                new Potion("Healing Potion", HEALING_POTION_QUANTITY),
                new Potion("Mana Potion", MANA_POTION_QUANTITY),
                new Potion("Stamina Potion", STAMINA_POTION_QUANTITY)
        );
        executor = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
        gatherAllIngredients(potions);
    }

    @SneakyThrows
    private static void gatherAllIngredients(@NonNull List<Potion> potions) {
        List<CompletableFuture<Integer>> futures = potions.stream()
                .map(potion -> CompletableFuture.supplyAsync(() -> {
                    return gatherIngredients(potion);
                }, executor))
                .toList();

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[futures.size()])).get(TIMEOUT_MIN,
                TimeUnit.MINUTES);
        AtomicInteger totalIngredients = new AtomicInteger(0);
        futures.forEach(future -> totalIngredients.addAndGet(future.join()));
        log.info("Общее количество собранных ингредиентов: {}", totalIngredients);
        executor.shutdown();
        if (!executor.awaitTermination(TIMEOUT_MIN, TimeUnit.MINUTES)) {
            executor.shutdownNow();
        }
    }

    @SneakyThrows
    private static int gatherIngredients(@NonNull Potion potion) {
        int requiredIngredients = potion.getRequiredIngredients();
        for (int count = 1; count <= requiredIngredients; count++) {
            Thread.sleep(GATHER_TIME_MSEC);
            log.info("Собрали {} в количестве: {}, осталось собрать: {}", potion.getName(), count,
                    (requiredIngredients - count));
        }
        return requiredIngredients;
    }
}
