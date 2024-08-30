package faang.school.godbless.task.multithreading.async.alchemy;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.stream.IntStream;

@Slf4j
public class Main {
    private static final int NUMBER_OF_POTIONS = 7;
    private static final int MAX_INGREDIENTS = 11;
    private static final int THREAD_POOL_SIZE = NUMBER_OF_POTIONS;

    private static final GatherManager gatherManager = new GatherManager(THREAD_POOL_SIZE);
    private static final Random random = new Random();
    private static final List<CompletableFuture<Integer>> futures = new ArrayList<>();
    private static List<Potion> potions = getPotions();

    public static void main(String[] args) {
        futures.addAll(runTask());
        printSumOfIngredients();
        gatherManager.getExecutor().shutdown();
    }

    private static List<CompletableFuture<Integer>> runTask() {
        return potions
                .stream()
                .map(gatherManager::gatherIngredients)
                .toList();
    }

    private static void printSumOfIngredients() {
        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]))
                .thenApply(v -> calculateSum())
                .thenAccept(sum -> log.info("Total number of ingredients collected: {}", sum));
    }

    private static int calculateSum() {
        return futures
                .stream()
                .mapToInt(CompletableFuture::join)
                .sum();
    }

    private static List<Potion> getPotions() {
        return IntStream
                .rangeClosed(1, NUMBER_OF_POTIONS)
                .mapToObj(i -> new Potion("Potion " + i, getIngredients()))
                .toList();
    }

    private static int getIngredients() {
        return random.nextInt(MAX_INGREDIENTS - 1) + 1;
    }
}
