package faang.school.godbless.BJS2_25230;

import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;
import java.util.stream.IntStream;

@AllArgsConstructor
public class Potion {
    private static final Random RANDOM = new Random();

    private String name;
    private int requiredIngredients;

    public List<CompletableFuture<Integer>> gatherIngredients() {
        System.out.printf("Поиск всего необходимого для %s%n", name);

        ExecutorService executor = Executors.newFixedThreadPool(requiredIngredients);
        var ingredients = IntStream.rangeClosed(1, requiredIngredients)
                .mapToObj(i -> CompletableFuture.supplyAsync(
                        findIngredient(i), executor))
                .toList();
        CompletableFuture.allOf(ingredients.toArray(new CompletableFuture[0])).join();

        System.out.printf("Поиск для %s закончен%n", name);
        shutdown(executor);
        return ingredients;
    }

    private Supplier<Integer> findIngredient(int number) {
        return () -> {
            System.out.printf("Поиск ингредиента: %d%n", number);
            try {
                Thread.sleep(RANDOM.nextLong(1_000L, 10_000L));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            System.out.printf("%d найден!%n", number);

            return number;
        };
    }

    private void shutdown(ExecutorService executor) {
        executor.shutdown();
        try {
            if (!executor.awaitTermination(10, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }
    }
}
