package faang.school.godbless.boosting_alchemy;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

@AllArgsConstructor
@Getter
public class PotionCollectService {
    private AtomicInteger totalIngredients;

    public CompletableFuture<Integer> gatherIngredients(Potion potion, Executor executor) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(new Random().nextInt(1500));
                return potion.getRequiresIngredients();
            } catch (InterruptedException e) {
                throw new RuntimeException(String.format("Interrupted from %s: %s", Thread.currentThread().getName(), potion.getName()));
            }
        }, executor);
    }
}
