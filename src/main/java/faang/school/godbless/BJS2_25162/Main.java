package faang.school.godbless.BJS2_25162;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    public static void main(String[] args) {

        List<Potion> potions = List.of(new Potion("Mandragora", 5),
                new Potion("Muchomor", 3),
                new Potion("Geksoral", 8),
                new Potion("Lovers", 2));

        AtomicInteger totalIngredients = new AtomicInteger(0);

        CompletableFuture<Void> allOf = CompletableFuture.allOf(potions.stream()
                .map(potion -> (gatherIngredients(potion)
                        .thenApply(totalIngredients::addAndGet)))
                .toArray(CompletableFuture[]::new));
        allOf.join();

        System.out.println("Total number of ingredients that need is " + totalIngredients.get());
    }

    public static CompletableFuture<Integer> gatherIngredients(Potion potion){
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return potion.getRequiredIngredients();
        });
    }
}
