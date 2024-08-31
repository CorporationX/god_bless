package faang.school.godbless;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Potion> potions = Arrays.asList(
                new Potion("Зелье здоровья", 5),
                new Potion("Зелье маны", 3),
                new Potion("Strength Potion", 7)
        );
        List<CompletableFuture<Integer>> futures = potions.stream()
                .map(Main::gatherIngredients)
                .collect(Collectors.toList());

        CompletableFuture<Void> all = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));

        all.join();


    }

    public static CompletableFuture<Integer> gatherIngredients(Potion potion) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2_000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return potion.getRequiredIngredients();
        });
    }
}
