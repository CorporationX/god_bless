package school.faang.alchemy;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
@Data
public class PotionMaker {
    private static final int threadSleepDelay = 2000;
    private static AtomicInteger potionCounter = new AtomicInteger(0);

    public static CompletableFuture<Integer> gatherIngredient(Potion potion) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(threadSleepDelay);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new PotionInterruptedException("Произошла ошибка при получении ингредиента ", e);
            }
            return potion.getIngredient();
        });
    }

    public static void gatherAllIngredients(List<Potion> potionList) {
        List<CompletableFuture<Integer>> completableFutureList = potionList.stream()
                .map(PotionMaker::gatherIngredient)
                .toList();
        completableFutureList.forEach(future -> future.thenApply(potionCounter::addAndGet));
        CompletableFuture.allOf(completableFutureList.toArray(new CompletableFuture[0])).join();
        int total = potionCounter.get();
        log.info("Общее количество приготовленных зелий {}", total);
    }

}
