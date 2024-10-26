package school.faang.potiongathering;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class PotionGathering {


    public static void main(String[] args) {

        List<Potion> potions = new ArrayList<>();
        potions.add(new Potion("Healing Potion", 5));
        potions.add(new Potion("Mana Potion", 3));
        potions.add(new Potion("Stamina Potion", 4));

        List<CompletableFuture<Integer>> futures = potions.stream()
                .map(potion -> gatherIngredients(potion))
                .collect(Collectors.toList());

        resalt(futures);
    }

    public static CompletableFuture<Integer> gatherIngredients(Potion potion) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return potion.getRequiredIngredients();
        });
    }

    public static void resalt(List<CompletableFuture<Integer>> futures) {
        AtomicInteger totalIngredients = new AtomicInteger(0);
        futures.forEach(future -> totalIngredients.addAndGet(future.join()));
        int total = totalIngredients.get();
        System.out.println("Общее количество собранных ингредиентов: " + total);
    }
}

