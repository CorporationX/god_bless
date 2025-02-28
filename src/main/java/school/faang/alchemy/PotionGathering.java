package school.faang.alchemy;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

@Slf4j
public class PotionGathering {
    public static void main(String[] args) {
        List<Potion> potions = List.of(
                new Potion("Invisibility potion", 5),
                new Potion("Power reserve potion", 3),
                new Potion("Poison", 2)
        );

        gatherAllIngredients(potions);
    }

    private static CompletableFuture<Integer> gatherIngredients(Potion potion) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
            log.info("Collected {} ingredients for {}", potion.getRequiredIngredients(), potion.getName());
            return potion.getRequiredIngredients();
        });
    }

    private static void gatherAllIngredients(List<Potion> potions) {
        List<CompletableFuture<Integer>> futures = potions.stream()
                .map(PotionGathering::gatherIngredients)
                .collect(Collectors.toList());

        int totalIngredients = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]))
                .thenApply(t -> futures.stream()
                        .map(CompletableFuture::join)
                        .reduce(0, Integer::sum))
                .join();
        log.info("Total amount of ingredients collected: {}", totalIngredients);
    }
}

