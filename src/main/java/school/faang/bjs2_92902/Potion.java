package school.faang.bjs2_92902;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
@Getter
public class Potion {
    private final String name;
    private final int ingredientsCount;

    private static final int GATHER_TIME = 4;
    private static final int THREAD_COUNT = 4;

    private static final ExecutorService executor = Executors.newFixedThreadPool(THREAD_COUNT);

    public Potion(String name, int ingredientsCount) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Имя зелья не должно быть пустым или null");
        }
        if (ingredientsCount < 0) {
            throw new IllegalArgumentException("Количество ингредиентов зелья не может быыть отрицательным");
        }
        this.name = name;
        this.ingredientsCount = ingredientsCount;
    }

    private CompletableFuture<Integer> gatherAllIngredientsOfSinglePotion(Potion potion) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(GATHER_TIME);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                log.info("Прервали в процессе сбора");
            }
            return potion.getIngredientsCount();
        }, executor);
    }

    public static void gatherAllIngredients(List<Potion> potions) {
        AtomicInteger total = new AtomicInteger(0);

        List<CompletableFuture<Void>> futures = potions.stream()
                .map(potion -> potion.gatherAllIngredientsOfSinglePotion(potion)
                        .thenAccept(total::addAndGet)
                )
                .toList();

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();
        System.out.println("Собрано ингредиентов: " + total);
    }

    public static void main(String[] args) {
        List<Potion> potions = Arrays.asList(
                new Potion("Power Up Potion", 12),
                new Potion("Speed Up Potion", 6),
                new Potion("Invisibility Potion", 25),
                new Potion("Time Stop Potion", 40)
        );
        gatherAllIngredients(potions);

        executor.shutdown();
        try {
            if (!executor.awaitTermination(10, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.info("Прервали во время ожидания завершения всех задач");
            Thread.currentThread().interrupt();
        }
    }
}