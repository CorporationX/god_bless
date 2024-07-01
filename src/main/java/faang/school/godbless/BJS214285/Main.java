package faang.school.godbless.BJS214285;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    private static int NUMBER_THREADS = 5;
    private static ResultIngredientsCounter result = new ResultIngredientsCounter();

    public static void main(String[] args) {
        List<Potion> potions = List.of(new Potion("A", 10), new Potion("B", 20)
                , new Potion("C", 10), new Potion("D", 40));

        System.out.println(getAllIIngredients(potions));
    }

    public static int getAllIIngredients(List<Potion> potions) {
        ExecutorService executor = Executors.newFixedThreadPool(NUMBER_THREADS);
        List<CompletableFuture<Void>> futures = potions.stream()
                .map(potion ->
                        CompletableFuture.runAsync(() -> potion.gatherIngredients(result), executor))
                .toList();
        CompletableFuture<Void> allOff = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));

        try {
            allOff.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();
        }
        return result.getSumOfAllIngredients();
    }

}
