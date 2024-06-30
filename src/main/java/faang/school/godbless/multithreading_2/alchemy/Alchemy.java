package faang.school.godbless.multithreading_2.alchemy;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

public class Alchemy {

    private static final AtomicInteger amountIngredients = new AtomicInteger();

    public static void main(String[] args) {
        List<Potion> potions = new ArrayList<>(List.of(
                new Potion("Снотворное", 3),
                new Potion("Оборотное зелье", 4),
                new Potion("Отвар из виверны", 5),
                new Potion("Гром", 2),
                new Potion("Раффар", 4),
                new Potion("Кошка", 3),
                new Potion("Ласточка", 5)
        ));

        System.out.println(gatherIngredients(potions));
    }

    private static int gatherIngredients(List<Potion> potions) {
        List<CompletableFuture<Void>> potionFutures = potions.stream()
                .map(potion -> CompletableFuture.runAsync(() -> {
                    try {
                        Thread.sleep(potion.requiredIngredients());
                        amountIngredients.addAndGet(potion.requiredIngredients());
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }))
                .toList();

        CompletableFuture.allOf(potionFutures.toArray(new CompletableFuture[0])).join();
        return amountIngredients.get();
    }

}
