package faang.school.multithreadingparallelismthread.pumpingalchemy;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class Main {

    public static void main(String[] args) {
        PotionMaker potionMaker = new PotionMaker();

        List<Potion> potions = List.of(
                new Potion("Algerian healing potion", 3),
                new Potion("A chilled potion", 2),
                new Potion("The courage involved", 5));


        AtomicInteger sum = new AtomicInteger();

        CompletableFuture<Void> completableFuture = CompletableFuture.allOf(potions.stream()
                .map(potion -> CompletableFuture.supplyAsync(() -> potionMaker.gatherIngredients(potion))
                        .thenApply(sum::addAndGet))
                .toArray(CompletableFuture[]::new));

        completableFuture.join();
    }
}
