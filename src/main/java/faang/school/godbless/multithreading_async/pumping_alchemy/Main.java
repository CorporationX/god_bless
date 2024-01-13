package faang.school.godbless.multithreading_async.pumping_alchemy;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        List<Potion> potions =
                Stream.of(new Potion("Potion_1", 1),
                                new Potion("Potion_2", 4),
                                new Potion("Potion_3", 5),
                                new Potion("Potion_4", 5))
                        .toList();

        AtomicInteger atomicInteger = new AtomicInteger();

        List<CompletableFuture<Integer>> ingFutures =
                potions.stream().map(potion -> CompletableFuture.supplyAsync(() -> gatherIngredients(potion))).toList();


        CompletableFuture.allOf(ingFutures.toArray(new CompletableFuture[0]))
                .thenRun(() -> ingFutures.forEach(ing -> atomicInteger.addAndGet(ing.join())))
                .join();

        System.out.println("общее количество собранных ингредиентов " + atomicInteger.get());
    }


    static int gatherIngredients(Potion potion) {
        System.out.println(Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
            return potion.getRequiredIngredients();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
