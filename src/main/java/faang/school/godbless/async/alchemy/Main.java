package faang.school.godbless.async.alchemy;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class Main {

    public static void main(String[] args) {
        List<Potion> potions = List.of(
                new Potion("Strength potion", 5),
                new Potion("Healing potion", 3),
                new Potion("Stealth potion", 7));
        AtomicInteger totalIngredients = new AtomicInteger(0);
        var futures = potions.stream()
                .map(potion -> gatherIngredients(potion, totalIngredients))
                .toList();
        var allFutures = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));
        allFutures.join();
        log.info("Общее количество собранных ингредиентов: {}", totalIngredients);
    }

    public static CompletableFuture<Void> gatherIngredients(Potion potion, AtomicInteger totalIngredients) {
        return CompletableFuture.runAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                log.error(e.getMessage());
            }
            totalIngredients.addAndGet(potion.requiredIngredients());
        });
    }
}
