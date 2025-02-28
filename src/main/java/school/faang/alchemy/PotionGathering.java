package school.faang.alchemy;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Slf4j
public class PotionGathering {
    public static void main(String[] args) {
        List<Potion> potions = List.of(
                new Potion("Healing Potion", 5),
                new Potion("Mana Potion", 3),
                new Potion("Stamina Potion", 4)
        );

        gatherAllIngredients(potions);
    }

    public static void gatherAllIngredients(List<Potion> potions) {
        AtomicInteger totalIngredients = new AtomicInteger(0);

        List<CompletableFuture<Integer>> futures = potions.stream()
                .map(PotionGathering::gatherIngredients)
                .toList();

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();

        futures.forEach(future -> future.thenApply(totalIngredients::addAndGet));
        System.out.println("Общее количество собранных ингредиентов: " + totalIngredients.get());
    }

    public static CompletableFuture<Integer> gatherIngredients(Potion potion) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println("Сбор ингредиентов для " + potion.getName());
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                log.info(e.getMessage(), e);
                Thread.currentThread().interrupt();
            }
            return potion.getRequiredIngredients();
        });
    }
}
