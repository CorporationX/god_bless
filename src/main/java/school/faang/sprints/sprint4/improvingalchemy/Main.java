package school.faang.sprints.sprint4.improvingalchemy;

import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class Main {

    public static final long SEC_IN_MILLIS = 1000;
    public static final int MAX_INGREDIENTS = 11;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        int generatedPotionsNum = 10;

        List<Potion> potions = generatePotions(generatedPotionsNum);

        AtomicInteger ingredientsSum = new AtomicInteger();

        Stream<CompletableFuture<Void>> futureIngredientsValue = runPotionIngredientsGathering(potions, executorService)
                .map(f -> f.thenAccept(ingredientsSum::addAndGet));

        CompletableFuture.allOf(futureIngredientsValue.toArray(CompletableFuture[]::new))
                .thenRun(
                        () -> System.out.println("Общее количество собранных ингредиентов: " + ingredientsSum.get())
                );
    }

    private static Stream<CompletableFuture<Integer>> runPotionIngredientsGathering(List<Potion> potions, ExecutorService executorService) {
        return potions.stream()
                .map(p -> CompletableFuture.supplyAsync(() -> gatherIngredients(p), executorService));
    }

    public static int gatherIngredients(Potion potion) {
        try {
            int requiredIngredients = potion.getRequiredIngredients();
            Thread.sleep(requiredIngredients * SEC_IN_MILLIS);

            return requiredIngredients;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException("Gathering ingredients was interrupted");
        }
    }

    public static List<Potion> generatePotions(int n) {
        AtomicInteger i = new AtomicInteger();
        return Stream.generate(() -> new Potion("potion_" + i.getAndIncrement(), new Random().nextInt(MAX_INGREDIENTS)))
                .limit(n)
                .toList();
    }
}
