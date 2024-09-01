package faang.school.godbless.sprint4.elderScrolls;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class Main {
    private static final int QUANTITY_OF_POTIONS = 100;
    private static final List<Potion> potions = new ArrayList<>(QUANTITY_OF_POTIONS);
    private static final Random random = new Random();
    private static final AtomicInteger sumOfAllIngredients = new AtomicInteger(0);
    private static final ExecutorService executor = Executors.newFixedThreadPool(QUANTITY_OF_POTIONS);
    private static List<CompletableFuture<Integer>> futures;

    public static void main(String[] args) {
        createPotionsList();
        createListOfFutures();
        countSumOfAllIngredients();
        executor.shutdown();
    }

    private static void countSumOfAllIngredients() {
        CompletableFuture
                .allOf(futures.toArray(CompletableFuture[]::new))
                .thenRun(() -> System.out.printf("Sum of all ingredients: %s%n", sumOfAllIngredients))
                .join();
    }

    private static void createListOfFutures() {
        futures = potions.stream()
                .map(potion -> CompletableFuture
                        .supplyAsync(() -> gatherIngredients(potion)))
                .toList();
    }

    private static int gatherIngredients(Potion potion) {
        int requiredIngredients = potion.getRequiredIngredients();
        try {
            Thread.sleep(requiredIngredients * 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        sumOfAllIngredients.addAndGet(requiredIngredients);
        return requiredIngredients;
    }

    private static void createPotionsList() {
        IntStream.rangeClosed(1, QUANTITY_OF_POTIONS)
                .forEach(number -> potions.add(new Potion(String.format("Potion %s", number), random.nextInt(1, 11))));
    }
}
