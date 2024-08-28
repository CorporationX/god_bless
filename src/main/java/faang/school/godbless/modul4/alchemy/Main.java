package faang.school.godbless.modul4.alchemy;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class Main {
    public static void main(String[] args) {
        var ingredients = new AtomicInteger(0);
        var futuresArray = new CompletableFuture[0];

        List<Potion> potions = List.of(
                new Potion("Health Potion", 4),
                new Potion("Mana Potion", 5),
                new Potion("Stamina Potion", 3),
                new Potion("Resistance Potion", 5)
        );

        List<CompletableFuture<Integer>> futureList = potions.stream()
                .map(Main::gatherIngredients)
                .toList();

        CompletableFuture.allOf(futureList.toArray(futuresArray))
                .thenApply(unused -> getIntegerList(futureList))
                .join()
                .forEach(ingredients::getAndAdd);

        log.info("Total ingredients: " + ingredients.get());
    }

    private static CompletableFuture<Integer> gatherIngredients(Potion potion) {
        return CompletableFuture.supplyAsync(() -> {
            int requiredIngredients = potion.getRequiredIngredients();
            try {
                Thread.sleep(requiredIngredients * 1000L);
                log.info("Gather ingredients for " + potion.getName());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return requiredIngredients;
        });
    }

    private static List<Integer> getIntegerList(List<CompletableFuture<Integer>> futures) {
        return futures.stream()
                .map(CompletableFuture::join)
                .toList();
    }
}
