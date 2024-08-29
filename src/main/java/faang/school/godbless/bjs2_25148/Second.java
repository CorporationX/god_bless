package faang.school.godbless.bjs2_25148;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

public class Second {
    private static final int INIT_VALUE = 0;
    private static final int POTION_AMOUNT = 5;

    public static void main(String[] args) {
        List<Potion> potions = initPotions();

        AtomicInteger totalAmount = new AtomicInteger(INIT_VALUE);

        List<CompletableFuture<Void>> futures = potions.stream()
                .map(potion -> gatherIngredients(potion)
                        .thenAccept(totalAmount::addAndGet))
                .toList();

        CompletableFuture
                .allOf(futures.toArray(CompletableFuture[]::new))
                .thenAccept(v -> System.out.println("Total amount: " + totalAmount.get()))
                .join();
    }

    public static CompletableFuture<Integer> gatherIngredients(Potion potion) {
        return CompletableFuture.supplyAsync(() -> {
            sleepThread();
            return potion.getRequiredIngredients();
        });
    }

    private static List<Potion> initPotions() {
        List<Potion> potions = new ArrayList<>();
        Random random = new Random();
        for (int i = 1; i <= POTION_AMOUNT; i++) {
            potions.add(new Potion("p" + i, i));
        }
        return potions;
    }

    private static void sleepThread() {
        try {
            Thread.sleep(1_000L * new Random().nextInt(5) + 1);
        } catch (InterruptedException e) {
            System.out.println("Thread was interrupted");
        }
    }
}
