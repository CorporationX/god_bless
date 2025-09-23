package school.faang.bjs2_92865;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) {
        Potion potion1 = new Potion("porion1", 3);
        Potion potion2 = new Potion("porion2", 4);
        Potion potion3 = new Potion("porion3", 2);
        Potion potion4 = new Potion("porion4", 5);
        Potion potion5 = new Potion("porion5", 3);
        Potion potion6 = new Potion("porion6", 6);

        List<Potion> potions = new ArrayList<>();
        potions.add(potion1);
        potions.add(potion2);
        potions.add(potion3);
        potions.add(potion4);
        potions.add(potion5);
        potions.add(potion6);

        PotionService potionService = new PotionService();

        List<CompletableFuture<Integer>> futures = potions.stream()
                .map(potionService::gatherIngredients)
                .toList();

        AtomicInteger atomicInteger = new AtomicInteger(0);

        futures.forEach(future -> {
            future.join();
            future.thenApply(atomicInteger::addAndGet);
        });

        System.out.println(atomicInteger.get());
    }
}
