package faang.school.godbless.alchemy;

import lombok.SneakyThrows;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    private static final AtomicInteger COUNTER_OF_NEED_POTIONS = new AtomicInteger();
    private static final int NUM_THREAD = 8;

    public static void main(String[] args) {

        ExecutorService pool = Executors.newFixedThreadPool(NUM_THREAD);

        List<Potion> potions = List.of(
                new Potion("potion1", List.of(1, 2)),
                new Potion("potion2", List.of(3, 4)),
                new Potion("potion3", List.of(5, 6)),
                new Potion("potion4", List.of(1, 2))
        );

        List<CompletableFuture<Integer>> futures = potions.stream()
                .map((potion) -> gatherIngredients(potion, pool)).toList();

        pool.shutdown();
        try {
            while (!pool.awaitTermination(10, TimeUnit.SECONDS)) {
            }
        } catch (InterruptedException e) {
            throw new RuntimeException();
        }

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();

        System.out.println(COUNTER_OF_NEED_POTIONS.get());
    }

    @SneakyThrows
    public static CompletableFuture<Integer> gatherIngredients(Potion potion, ExecutorService pool) {
        TimeUnit.SECONDS.sleep(potion.getRequiredIngredients().size());
        return CompletableFuture.supplyAsync(() -> potion.getRequiredIngredients().size(), pool).thenApply(COUNTER_OF_NEED_POTIONS::addAndGet);
    }
}