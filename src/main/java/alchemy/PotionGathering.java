package alchemy;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class PotionGathering {
    private static final ExecutorService executor = Executors.newFixedThreadPool(4);

    public static void main(String[] args) {
        List<Potion> potions = List.of(
                new Potion("Healing Potion", 5),
                new Potion("Mana Potion", 3),
                new Potion("Stamina Potion", 4)
        );

        gatherAllIngredients(potions);
        executor.shutdown();
    }

    public static void gatherAllIngredients(List<Potion> potions) {
        Objects.requireNonNull(potions, "Список зелий не должен быть null");

        AtomicInteger totalIngredients = new AtomicInteger(0);

        List<CompletableFuture<Void>> futures = potions.stream()
                .map(potion -> gatherIngredients(potion)
                        .thenAccept(totalIngredients::addAndGet))
                .toList();

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();
        log.info("Общее количество собранных ингредиентов: {}", totalIngredients.get());
    }

    public static CompletableFuture<Integer> gatherIngredients(Potion potion) {
        Objects.requireNonNull(potion, "Зелье не должно быть null");

        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                log.error("Ошибка при сборе ингредиентов для зелья '{}'.", potion.getName(), e);
                Thread.currentThread().interrupt();
                throw new RuntimeException("Ошибка при сборе ингредиентов для зелья '" + potion.getName() + "'", e);
            }
            return potion.getRequiredIngredients();
        }, executor);
    }
}

