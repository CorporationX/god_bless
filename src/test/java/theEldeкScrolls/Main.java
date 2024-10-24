package theEldeкScrolls;

import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<Potion> potions = List.of(
                new Potion("Healing Potion",5),
                new Potion("Mana Potion",3),
                new Potion("Stamina Potion",4)
        );
        List<CompletableFuture<Integer>> futures = potions.stream()
                .map(potion -> gatherIngridients(potion))
                .collect(Collectors.toList());
        CompletableFuture<Void> allTask = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));
        allTask.thenRun(() -> {
            int totalIngridients = futures.stream()
                    .mapToInt(CompletableFuture::join)
                    .sum();
            System.out.println("Total ingredients gathered: "+totalIngridients);
        });
        allTask.join();

    }

    public static CompletableFuture<Integer> gatherIngridients(Potion potion) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return potion.getRequiredIngredients();
        });
    }
}
