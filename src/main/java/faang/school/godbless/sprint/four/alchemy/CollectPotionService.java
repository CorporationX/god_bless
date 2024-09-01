package faang.school.godbless.sprint.four.alchemy;

import lombok.Getter;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

@Getter
public class CollectPotionService {
    private final AtomicInteger commonPotionAmount = new AtomicInteger(0);

    public CompletableFuture<Integer> gatherIngredients(Potion potion) {
        return CompletableFuture.supplyAsync(() -> {
            Random random = new Random();
            int potionAmount = random.nextInt(10);
            System.out.printf("Collecting required ingredients for potion '%s' in amount of %d%n",
                    potion.getName(), potionAmount);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            potion.setRequiredIngredients(potionAmount);
            System.out.printf("Required ingredients have been collected for potion '%s' in amount of %d%n",
                    potion.getName(), potionAmount);
            commonPotionAmount.addAndGet(potionAmount);
            return potionAmount;
        });
    }

}
