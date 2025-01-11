package school.faang.bjs250902;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Slf4j
public class Main {
    public static void main(String[] args) {
        Gathering gathering = new Gathering();

        List<Potion> potions = List.of(
                new Potion("Healing Potion", 9),
                new Potion("Big Potion", 20),
                new Potion("Stamina Potion", 5),
                new Potion("Kix Potion", 5)
        );

        List<CompletableFuture<Integer>> completableFutures = potions.stream()
                .map(potion -> gathering.gatherIngredients(potion)
                        .thenApply(ingredients -> {
                            gathering.getTotalNumberOfIngredients().addAndGet(ingredients);
                            return ingredients;
                        }))
                .toList();

        CompletableFuture.allOf(completableFutures.toArray(new CompletableFuture[0])).join();

        int totalNumber = gathering.getTotalNumberOfIngredients().get();
        log.info("Total amount of ingredients collected: {}", totalNumber);

        gathering.shutdownExecutorService();
    }
}