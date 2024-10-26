package school.faang.BJS238705;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Potion> potions = List.of(
                new Potion("Healing Potion", 5),
                new Potion("Mana Potion", 3),
                new Potion("Stamina Potion", 4)
        );

        gatherAllIngredients(potions);
    }

    private static void gatherAllIngredients(List<Potion> potions) {
        AtomicInteger totalIngredients = new AtomicInteger();
        List<CompletableFuture<Integer>> futures = potions.stream()
                .map(potion -> gatherIngredients(potion))
                .collect(Collectors.toList());
        futures.forEach(future -> totalIngredients.addAndGet(future.join()));
        System.out.println("Общее количество ингредиентов: " + totalIngredients.get());
    }

    private static CompletableFuture<Integer> gatherIngredients(Potion potion) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(potion.getRequiredIngredients() * 1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return potion.getRequiredIngredients();
        });
    }
}
