package faang.school.godbless.async.alchemy;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class Main {

    private static final int DEFAULT_POISON_NUMBER = 4;
    private static final int MAX_POISON_ING_CREATION_NUMBER = 7;
    public static void main(String[] args) {
        IngredientsGathering gatherer = new IngredientsGathering();
        List<Potion> potions = generatePotions(DEFAULT_POISON_NUMBER);

        AtomicInteger totalIngredientsGathered = new AtomicInteger();

        List<CompletableFuture<Void>> cfs = potions.stream()
                .map(potion -> gatherer.gatherIngredientsAsync(potion) // Нормально ли запускать потоки через .map? Выглядит неочевидно
                                                                       // upd: Я добавил в название метода "Async" - стало получше =)
                        .thenAccept(totalIngredientsGathered::addAndGet)
                )
                .toList();

        CompletableFuture.allOf(cfs.toArray(new CompletableFuture[cfs.size()]))
                .join();

        System.out.printf("Total ingredients gathered: %s\n", totalIngredientsGathered.get());
    }

    private static List<Potion> generatePotions(int i) {
        if (i < 1) {
            throw new IllegalArgumentException("Generating list size should be >= 1");
        }

        return IntStream.rangeClosed(1, i)
                .boxed()
                .map(integer -> new Potion("Potion " + integer,
                        ThreadLocalRandom.current()
                                .nextInt(1, MAX_POISON_ING_CREATION_NUMBER + 1)))
                .toList();
    }
}
