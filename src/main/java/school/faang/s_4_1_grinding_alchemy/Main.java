package school.faang.s_4_1_grinding_alchemy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) {
        List<Potion> potions = new ArrayList<>(Arrays.asList(
                new Potion("RosePotion", 3),
                new Potion("WaterPotion", 1),
                new Potion("CamomilePotion", 4),
                new Potion("GrassPotion", 10)
        ));
        AtomicInteger total = new AtomicInteger();
        ExecutorService executor = Executors.newFixedThreadPool(4);
        List<CompletableFuture<Void>> gathers = potions.stream()
                .map(potion -> CompletableFuture.runAsync(() -> {
                    total.addAndGet(potion.gatheringIngredients());
                }, executor))
                .toList();
        CompletableFuture.allOf(gathers.toArray(new CompletableFuture[0])).join();
        System.out.println("Total gathered ingredients: " + total.get());
        executor.shutdown();
    }
}
