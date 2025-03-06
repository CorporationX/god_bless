package school.faang.BJS2_64847;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

public class PotionGathering {
    private static final int TIME_THREAD_SLEEP = 100;
    private static final AtomicInteger ingredients = new AtomicInteger(0);

    public static void main(String[] args) {
        List<Potion> potions = List.of(
                new Potion("Healing Potion", 5),
                new Potion("Mana Potion", 3),
                new Potion("Stamina Potion", 4)
        );
        gatherAllIngredients(potions);
        System.out.printf("%d ingredients\n", ingredients.get());
    }

    private static void gatherAllIngredients(List<Potion> potions) {
        List<CompletableFuture<Integer>> futures = potions.stream()
                .map(PotionGathering::gatherIngredients)
                .toList();
        CompletableFuture.allOf(futures.toArray(new CompletableFuture[futures.size()])).join();
    }

    private static CompletableFuture<Integer> gatherIngredients(Potion potion) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(TIME_THREAD_SLEEP);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return ingredients.addAndGet(potion.getRequiredIngredients());
        });
    }
}
