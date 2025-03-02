package BJS262501;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class Main {
    public static void main(String[] args) {
        List<Potion> potions = List.of(
                new Potion("Healing Potion", 5),
                new Potion("Mana Potion", 3),
                new Potion("Stamina Potion", 10)
        );
        ExecutorService executor = Executors.newFixedThreadPool(potions.size());

        List<CompletableFuture<Integer>> futuresIngredients = potions.stream()
                .map(potion ->
                        CompletableFuture.supplyAsync(() -> potion.gatherIngredients(potion), executor))
                .toList();

        CompletableFuture<Void> allOf = CompletableFuture.allOf(futuresIngredients.toArray(new CompletableFuture[0]));
        allOf.thenRun(() -> {
            int result =
                    futuresIngredients.stream().mapToInt(CompletableFuture::join).sum();
            log.info("Ingredients : {} collected", result);
        }).join();

        executor.shutdown();
    }


}
