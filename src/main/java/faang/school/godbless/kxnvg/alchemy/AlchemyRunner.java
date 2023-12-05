package faang.school.godbless.kxnvg.alchemy;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicInteger;

@AllArgsConstructor
public class AlchemyRunner {

    private  List<Potion> potions;

    public static void main(String[] args) {
        AlchemyRunner alchemy = new AlchemyRunner(getPotions());

        List<CompletableFuture<Integer>> completableFutures = alchemy.potions.stream()
                .map(potion -> CompletableFuture.supplyAsync(() -> alchemy.gatherIngredients(potion)))
                .toList();

        CompletableFuture<Void> allOfFuture = CompletableFuture.allOf(completableFutures.toArray(new CompletableFuture[0]));

        Integer allIngredients = allOfFuture.thenApply(x -> {
            AtomicInteger result = new AtomicInteger(0);
            for (CompletableFuture<Integer> future : completableFutures) {
                try {
                    result.addAndGet(future.get());
                } catch (InterruptedException | ExecutionException e) {
                    throw new RuntimeException(e);
                }
            }
            return result.get();
        }).join();

        System.out.println(allIngredients);
    }

    public int gatherIngredients(Potion potion) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return potion.getRequiredIngredients();
    }

    public static List<Potion> getPotions() {
        List<Potion> potionList = new ArrayList<>();
        String potionName = "ingredient";

        for (int i = 0; i < 10; i++) {
            potionList.add(new Potion(potionName + i, 5));
        }
        return potionList;
    }
}
