package faang.school.godbless.pumping_alchemy;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    public static void main(String[] args) {
        List<Potion> potions = List.of(new Potion("Potion1", 1),
                new Potion("Potion2", 2),
                new Potion("Potion3", 3),
                new Potion("Potion4", 4),
                new Potion("Potion5", 5));

        AtomicInteger sum = new AtomicInteger();

        CompletableFuture<Void> completableFuture = CompletableFuture.allOf(
                potions.stream()
                        .map(potion -> CompletableFuture.supplyAsync(() -> gatherIngredients(potion))
                                .thenApply(sum::addAndGet))
                        .toArray(CompletableFuture[]::new));

        completableFuture.join();

        System.out.println("Результат = " + sum);
    }

    private static int gatherIngredients(Potion potion) {
        System.out.println(Thread.currentThread().getName() + " зашел в метод gatherIngredients");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }

        return potion.requiredIngredients();
    }
}
