package school.faang.bjs2_92943;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class Main {

    public static void main(String[] args) {

        List<Potion> potions = new ArrayList<>();
        potions.add(new Potion("Healing Potion", 5));
        potions.add(new Potion("Mana Potion", 3));
        potions.add(new Potion("Stamina Potion", 4));

        PotionGathering potionGathering = new PotionGathering();

        List<CompletableFuture<Integer>> gatherAllIngredients = potions.stream()
                .map(potion -> potionGathering.gatherIngredients(potion)).toList();

        AtomicInteger totalIngredients = new AtomicInteger(0);

        gatherAllIngredients.forEach(future -> future.thenApply(totalIngredients::addAndGet).join());
        gatherAllIngredients.forEach(CompletableFuture::join);

        log.info("All potion ingredients have been gathered!");
    }
}