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
                new Potion("Stamina Potion", 5)
        );

        List<CompletableFuture<Integer>> completableFutures = potions.stream()
                .map(gathering::gatherIngredients)
                .toList();

        CompletableFuture
                .allOf(completableFutures.toArray(CompletableFuture[]::new))
                .thenRun(() -> {
                    int totalNumberOfIngredients = potions.stream()
                            .mapToInt(Potion::requiredIngredients)
                            .sum();

                    log.info("Total number of ingredients is {}", totalNumberOfIngredients);
                })
                .join();
    }
}