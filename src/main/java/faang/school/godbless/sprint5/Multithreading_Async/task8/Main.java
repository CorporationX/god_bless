package faang.school.godbless.sprint5.Multithreading_Async.task8;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    public static void main(String[] args) {
        List<Potion> potions = getPotions();

        List<CompletableFuture<Integer>> completableFutures = potions.stream()
                .map(Potion::gatherIngredients)
                .toList();

        CompletableFuture<Integer>[] futureArray = new CompletableFuture[completableFutures.size()];
        completableFutures.toArray(futureArray);

        CompletableFuture<Void> allTaskCompletableFuture = CompletableFuture.allOf(futureArray);

        AtomicInteger sum = new AtomicInteger(0);
        allTaskCompletableFuture.thenRun(() -> {
            for (int i = 0; i < futureArray.length; i++) {
                try {
                    sum.addAndGet(futureArray[i].get());
                } catch (InterruptedException | ExecutionException e) {
                    throw new RuntimeException(e);
                }
            }
        }).join();

        System.out.println(sum);
    }

    private static List<Potion> getPotions() {
        Potion potion1 = new Potion("Восстановление запаса сил", 21);
        Potion potion2 = new Potion("Восстановление здоровья", 4);
        Potion potion3 = new Potion("Повышение искусства торговли", 7);
        Potion potion4 = new Potion("Повышение навыка: взлом", 6);
        Potion potion5 = new Potion("Повышение навыка: восстановление", 2);

        List<Potion> potions = new ArrayList<>();
        potions.add(potion1);
        potions.add(potion2);
        potions.add(potion3);
        potions.add(potion4);
        potions.add(potion5);

        return potions;
    }
}
