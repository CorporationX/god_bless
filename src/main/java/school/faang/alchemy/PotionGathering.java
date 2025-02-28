package school.faang.alchemy;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class PotionGathering {

    private static final long GATHERING_COEFFICIENT = 1000;

    public static void main(String[] args) {
        List<Potion> potions = List.of(
                new Potion("Healing Potion", 5),
                new Potion("Mana Potion", 3),
                new Potion("Stamina Potion", 4)
        );

        AtomicInteger totalAtomic = new AtomicInteger(0);
        List<CompletableFuture<Integer>> gatherFuture = gatherAllIngredients(potions);
        gatherFuture.forEach(gathering -> gathering.thenApply(totalAtomic::addAndGet));
        gatherFuture.forEach(CompletableFuture::join);
        log.info("Общее количество собранных ингредиентов: {}", totalAtomic.get());
    }

    private static int gatherIngredients(Potion potion) {
        log.info("Начинаю сбор ингридиентов для {}", potion.getName());
        try {
            Thread.sleep(potion.getRequiredIngredients() * GATHERING_COEFFICIENT);
        } catch (InterruptedException e) {
            log.error("Поток прерван во время сбора ингридиентов для {}", potion.getName(), e);
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
        log.info("Ингридиенты для {} собраны в количестве {} штук", potion.getName(), potion.getRequiredIngredients());
        return potion.getRequiredIngredients();
    }

    private static List<CompletableFuture<Integer>> gatherAllIngredients(List<Potion> potions) {
        return potions.stream()
                .map(potion -> CompletableFuture.supplyAsync(() -> gatherIngredients(potion)))
                .toList();
    }
}
