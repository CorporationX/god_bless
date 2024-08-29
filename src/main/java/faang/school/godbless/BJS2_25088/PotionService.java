package faang.school.godbless.BJS2_25088;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class PotionService {

    private static final List<Potion> potions = new ArrayList<>();
    private static final AtomicInteger totalIngredients = new AtomicInteger(0);

    public static void main(String[] args) {
        potions.addAll(List.of(new Potion("Amortentia", 6),
                new Potion("Death potion", 8),
                new Potion("Anti-Paralysis Potion", 3),
                new Potion("Felix Felicis", 12),
                new Potion("Memory Potion", 4)));

        List<CompletableFuture<Integer>> futures = potions.stream()
                .map(PotionService::gatherIngredients)
                .toList();

        CompletableFuture.allOf(futures.toArray(CompletableFuture[]::new)).join();


        System.out.println("Total " + totalIngredients + " potions");
    }

    public static CompletableFuture<Integer> gatherIngredients(Potion potion) {

        return CompletableFuture.supplyAsync(() -> {
                    System.out.println("Gathering ingredients for " + potion.getName());

                    try {
                        TimeUnit.SECONDS.sleep(potion.getRequiredIngredients());
                    } catch (InterruptedException e) {
                        log.error(e.getMessage());
                        throw new RuntimeException(e);
                    }

                    System.out.println("Ingredients for " + potion.getName() + " are gathered");

                    return potion.getRequiredIngredients();
                })
                .thenApply(ingredient -> totalIngredients.accumulateAndGet(ingredient, Integer::sum));
    }
}
