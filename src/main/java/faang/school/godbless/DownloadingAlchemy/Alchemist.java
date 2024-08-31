package faang.school.godbless.DownloadingAlchemy;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicInteger;

public class Alchemist {

    public CompletableFuture<Integer> gatherIngredients(Potion potion) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(potion.getRequiredIngredients() * 100L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return potion.getRequiredIngredients();
        });
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<Potion> potions = List.of(
                new Potion("Health Potion", 5),
                new Potion("Mana Potion", 3),
                new Potion("Stamina Potion", 4)
        );

        Alchemist alchemist = new Alchemist();
        AtomicInteger totalIngredients = new AtomicInteger(0);

        List<CompletableFuture<Void>> futures = potions.stream()
                .map(potion -> alchemist.gatherIngredients(potion)
                        .thenAccept(totalIngredients::addAndGet))
                .toList();

        CompletableFuture<Void> allOf = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));
        allOf.get();

        System.out.println("Total ingredients gathered: " + totalIngredients.get());
    }
}


