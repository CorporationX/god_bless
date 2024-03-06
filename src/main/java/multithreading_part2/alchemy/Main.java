package multithreading_part2.alchemy;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Main {
    public static AtomicInteger totalIngredients = new AtomicInteger(0);

    public static void gatherIngredients(List<Potion> potions) {
        List<CompletableFuture<Integer>> ingredients = potions.stream()
                .map(potion -> CompletableFuture.supplyAsync(() -> {
                            System.out.println("start gather ingredients for " + potion.getName());
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                            System.out.println("We need gather ingredients for " + potion.getName() + " " + potion.getRequiredIngredients());
                            return totalIngredients.addAndGet(potion.getRequiredIngredients());
                        }
                ))
                .collect(Collectors.toList());

        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.allOf(ingredients.toArray(new CompletableFuture[ingredients.size()]));
        voidCompletableFuture.join();
        System.out.println("We need for magic " + totalIngredients.get() + " ingredients");
    }

    public static void main(String[] args) {
        List<Potion> potions = new ArrayList<>();
        potions.add(new Potion("fly", 3));
        potions.add(new Potion("flash", 5));
        potions.add(new Potion("walk", 6));

        gatherIngredients(potions);
    }
}
