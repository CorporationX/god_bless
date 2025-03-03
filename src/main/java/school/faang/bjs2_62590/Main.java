package school.faang.bjs2_62590;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) {

        PotionGathering potionGathering = new PotionGathering();
        AtomicInteger counter = new AtomicInteger(0);

        List<Potion> potions = List.of(
                new Potion("Healing Potion", 5),
                new Potion("Mana Potion", 3),
                new Potion("Stamina Potion", 4)
        );

        // Асинхронный сбор ингредиентов
        List<CompletableFuture<Integer>> futures = potionGathering.gatherAllIngredients(potions);
        CompletableFuture<Void> allFutures = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));

        allFutures.thenRun(() -> futures.stream()
                .map(CompletableFuture::join)
                .forEach(counter::addAndGet)
                ).join();

        System.out.printf("Общее количество собранных ингредиентов: %d", counter.get());

    }
}
