package faang.school.godbless.alchemy;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) {
        AtomicInteger result = new AtomicInteger(0);
        Potion potionOne = new Potion("Potion 1", 1);
        Potion potionTwo = new Potion("Potion 2", 2);
        Potion potionThree = new Potion("Potion 3", 3);
        List<Potion> potions = List.of(potionOne, potionTwo, potionThree);
        List<CompletableFuture<Integer>> futures = new ArrayList<>();

        potions.forEach(potion -> {
            CompletableFuture<Integer> futureToAdd = CompletableFuture.supplyAsync(() -> {
                try {
                    return gatherIngredients(potion);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }).thenApply(ingredients -> result.accumulateAndGet(ingredients, Integer::sum));
            futures.add(futureToAdd);
        });

        CompletableFuture<Void> allOf = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));

        try {
            allOf.get();
            System.out.println("Res " + result.intValue());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
    public static Integer gatherIngredients(Potion potion) throws InterruptedException {
        Thread.sleep(500);
        return potion.getRequiredIngredients();
    }
}
