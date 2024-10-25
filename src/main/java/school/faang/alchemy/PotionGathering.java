package school.faang.alchemy;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class PotionGathering {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        List<Potion> potions = List.of(
                new Potion("Healing Potion", 5),
                new Potion("Mana Potion", 3),
                new Potion("Stamina Potion", 4)
        );

        AtomicInteger totalIngredients = new AtomicInteger(0);
        gatherAllIngredients(potions).forEach(f -> totalIngredients.addAndGet(f.join()));
        System.out.println("Total ingredients collected: " + totalIngredients.get());
    }

    public static List<CompletableFuture<Integer>> gatherAllIngredients(List<Potion> potions) {
        return potions.stream()
                .map(PotionGathering::gatherIngredients)
                .collect(Collectors.toList());
    }

    private static CompletableFuture<Integer> gatherIngredients(Potion potion) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                throw new IllegalStateException("Gather Ingredients process was interrupted");
            }
            return potion.getRequiredIngredients();
        });
    }
}
