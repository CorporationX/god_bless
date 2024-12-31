package school.faang.bjs250902;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class Main {
    private static final int INIT_NUMBER = 0;
    private static final AtomicInteger totalNumberOfIngredients = new AtomicInteger(INIT_NUMBER);

    public static void main(String[] args) {
        Gathering gathering = new Gathering();
        List<Potion> potions = List.of(
                new Potion("Healing Potion", 9),
                new Potion("Big Potion", 20),
                new Potion("Stamina Potion", 5),
                new Potion("Kix Potion", 5)
        );

        List<CompletableFuture<Integer>> completableFutures = potions.stream()
                .map(gathering::gatherIngredients)
                .toList();

        completableFutures.forEach(f -> totalNumberOfIngredients.addAndGet(f.join()));

        int totalNumber = totalNumberOfIngredients.get();
        log.info("Total amount of ingredients collected: {}", totalNumber);
    }
}