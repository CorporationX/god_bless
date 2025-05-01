package school.faang.async.alchemy;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class Main {
    public static void main(String[] args) {
        List<Potion> potions = List.of(
                new Potion("Healing Potion", 5),
                new Potion("Mana Potion", 3),
                new Potion("Stamina Potion", 4)
        );

        Integer totalIngredients = gatherAllIngredients(potions);
        log.info("Total ingredients collected: {}", totalIngredients);
    }

    private static Integer gatherAllIngredients(List<Potion> potions) {

        AtomicInteger totalIngredients = new AtomicInteger(0);

        List<CompletableFuture<Integer>> futurePotions = potions.stream()
                .map(Main::gatherIngredients)
                .toList();

        futurePotions.forEach(futurePotion -> futurePotion.thenAccept(totalIngredients::addAndGet));

        CompletableFuture
                .allOf(futurePotions.toArray(new CompletableFuture[0]))
                .join();

        return totalIngredients.get();
    }

    private static CompletableFuture<Integer> gatherIngredients(Potion potion) {

        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000L * potion.getRequiredIngredients());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return potion.getRequiredIngredients();
        });
    }
}
