package school.faang.levelingupalchemy;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class PotionGathering {
    public static void main(String[] args) {
        List<Potion> potions = List.of(
                new Potion("Healing Potion", 5),
                new Potion("Mana Potion", 3),
                new Potion("Stamina Potion", 4)
        );

    }

    public static void gatherAllIngredients(List<Potion> potions) {
        AtomicInteger totalIngredients = new AtomicInteger(0);

        List<CompletableFuture<Void>> futures = potions.stream()
                .map(potion -> CompletableFuture.supplyAsync(() -> gatherIngredients(potion))
                        .thenAccept(ingredients -> {
                            totalIngredients.addAndGet(ingredients);
                            System.out.println("Collected " + ingredients + " ingredients for " + potion.getName());
                        })
                ).collect(Collectors.toList());

        CompletableFuture<Void> allTasks = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));

        allTasks.thenRun(() -> System.out.println("Total ingredients gathered: " + totalIngredients.get()))
                .join();
    }

    public static int gatherIngredients(Potion potion) {
        try {
            System.out.println("Gathering ingredients for " + potion.getName() + "...");
            Thread.sleep(potion.getRequiredIngredients() * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return potion.getRequiredIngredients();
    }
}
