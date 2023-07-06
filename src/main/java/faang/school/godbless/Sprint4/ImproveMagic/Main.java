package faang.school.godbless.Sprint4.ImproveMagic;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        List<Potion> potions = new ArrayList<>();
        initializePotions(potions);

        List<CompletableFuture<Integer>> completableFutures = new ArrayList<>();
        for (Potion potion : potions) {
            completableFutures.add(CompletableFuture.supplyAsync(() -> {
                try {
                    return new Main().gatherIngredients(potion);
                } catch (InterruptedException e) {
                    System.out.println(e);
                }
                return 0;
            }));
        }

        Void allFutures = CompletableFuture.allOf(completableFutures.toArray(new CompletableFuture[completableFutures.size()])).join();
        System.out.println("all the futures are done!");
    }

    public int gatherIngredients(Potion potion) throws InterruptedException {
        System.out.println(potion.getName() + " is gathering ingredients...");
        Thread.sleep(potion.getTimeToSearch() * potion.getRequiredIngredients());
        System.out.println(potion.getName() + " is ready!");
        return potion.getRequiredIngredients();
    }

    private static void initializePotions(List<Potion> potions) {
        potions.add(new Potion("Potion1", 5, 2000));
        potions.add(new Potion("Potion2", 10, 1000));
        potions.add(new Potion("Potion3", 3, 5000));
        potions.add(new Potion("Potion4", 6, 2000));
        potions.add(new Potion("Potion5", 15, 1000));

    }
}
