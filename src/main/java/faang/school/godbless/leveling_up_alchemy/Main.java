package faang.school.godbless.leveling_up_alchemy;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        List<Potion> potionBag = new ArrayList<>();

        Potion potion1 = new Potion("Potions of Weakness", 6);
        Potion potion2 = new Potion("Thick Potion", 3);
        Potion potion3 = new Potion("Unremarkable Potion", 1);
        Potion potion4 = new Potion("Healing Potion", 7);

        potionBag.add(potion1);
        potionBag.add(potion2);
        potionBag.add(potion3);
        potionBag.add(potion4);

        List<CompletableFuture<Integer>> futures = potionBag.stream()
                .map(Potion :: gatherIngredients).toList();

        CompletableFuture<Void> counter = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));

        int countIngredients = counter.thenApply(n -> futures.stream()
                .mapToInt(CompletableFuture :: join)
                .sum())
                .join();

        System.out.println(countIngredients);
    }
}
