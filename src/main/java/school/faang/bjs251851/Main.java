package school.faang.bjs251851;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {

    public static void main(String[] args) {
        final long start = System.currentTimeMillis();
        List<Potion> potions = List.of(
                new Potion("Healing Potion", 5),
                new Potion("Mana Potion", 3),
                new Potion("Stamina Potion", 4)
        );

        List<CompletableFuture<Integer>> futures = potions.stream()
                .map(Main::gatherIngredients)
                .toList();

        Integer totalIngredients = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]))
                .thenApply(v -> futures.stream()
                        .map(CompletableFuture::join)
                        .reduce(0, Integer::sum))
                .join();
        System.out.println("Total ingredients: " + totalIngredients);
        long end = System.currentTimeMillis();
        System.out.println("time elapsed: " + (end - start));
    }

    public static CompletableFuture<Integer> gatherIngredients(Potion potion) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(potion.getRequiredIngredients() * 1000L);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return potion.getRequiredIngredients();
        });
    }

}
