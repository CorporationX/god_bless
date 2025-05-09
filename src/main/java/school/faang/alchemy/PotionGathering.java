package school.faang.alchemy;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class PotionGathering {
    public static void main(String[] args) {
        List<Potion> potions = List.of(
                new Potion("Healing Potion", 5),
                new Potion("Mana Potion", 3),
                new Potion("Stamina Potion", 4)
        );

        AtomicInteger totalIngredients = new AtomicInteger(0);

        List<CompletableFuture<Integer>> futures = potions.stream()
                .map(AlchemyService::gatherIngredients)
                .peek(future -> future.thenAccept(totalIngredients::addAndGet))
                .toList();

        CompletableFuture<Void> allDone = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));
        allDone.join();

        log.info("Общее количество собранных ингредиентов: {} ", totalIngredients.get());
    }
}
