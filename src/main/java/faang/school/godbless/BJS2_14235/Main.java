package faang.school.godbless.BJS2_14235;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) {
        Potion firstPotion = new Potion("first potion", 3);
        Potion secondPotion = new Potion("second potion", 6);
        Potion thirdPotion = new Potion("third potion", 14);
        Potion fourthPotion = new Potion("fourth potion", 17);

        List<Potion> potions = List.of(firstPotion, secondPotion, thirdPotion, fourthPotion);

        List<CompletableFuture<AtomicInteger>> allFutures = potions.stream()
                .map(potion -> {
                    try {
                        return gatherIngredients(potion);
                    } catch (ExecutionException | InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                })
                .toList();

        AtomicInteger result = new AtomicInteger(0);
        CompletableFuture.allOf(allFutures.toArray(new CompletableFuture[0])).join();
        allFutures.forEach(future -> {
            try {
                result.addAndGet(future.get().get());
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }
        });
        System.out.println("Total number of ingredients collected: " + result);
    }

    public static CompletableFuture<AtomicInteger> gatherIngredients(Potion potion) throws ExecutionException, InterruptedException {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(Const.DURATION_OF_INGREDIENTS_GATHERING);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage() + " Thread interrupted.");
                Thread.currentThread().interrupt();
            }
            return new AtomicInteger(potion.getRequiredIngredients());
        });
    }
}
