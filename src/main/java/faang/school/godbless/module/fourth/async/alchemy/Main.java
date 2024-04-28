package faang.school.godbless.module.fourth.async.alchemy;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.stream.IntStream;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    private static final AtomicInteger ATOMIC_INTEGER = new AtomicInteger();
    
    public static void main(String[] args) {
        List<Potion> potions = IntStream.range(0, 15)
            .mapToObj((number) -> new Potion("Pot" + number, number % 3))
            .toList();
        
        Function<Potion, CompletableFuture<Integer>> function = potion -> CompletableFuture
            .supplyAsync(() -> gatherIngredients(potion))
            .thenApply((number) -> ATOMIC_INTEGER.addAndGet(number));
        
        List<CompletableFuture<Integer>> futures = potions.stream()
            .map(function)
            .toList();
        CompletableFuture<Void> allCompletableFutures = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));
        allCompletableFutures.join();
        allCompletableFutures.thenRun(() -> log.info("Все зелья собраны. Количество {}", ATOMIC_INTEGER.get()));
    }
    
    public static int gatherIngredients(Potion potion) {
        int requiredIngredients = potion.getRequiredIngredients();
        log.info("Gathering {} ingredients for potion {}", requiredIngredients, potion.getName());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return requiredIngredients;
    }
}
