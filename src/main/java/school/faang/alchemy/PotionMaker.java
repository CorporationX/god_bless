package school.faang.alchemy;

import lombok.Data;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

@Data
public class PotionMaker {

    private static AtomicInteger potionCounter = new AtomicInteger(0);


    public static CompletableFuture<Integer> gatherIngredient(Potion potion) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
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
        System.out.println(total);
    }

}
