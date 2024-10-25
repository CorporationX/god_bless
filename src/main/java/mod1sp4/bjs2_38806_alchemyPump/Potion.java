package mod1sp4.bjs2_38806_alchemyPump;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.Random;
import java.util.concurrent.CompletableFuture;

@Slf4j
@Data
@AllArgsConstructor
public class Potion {
    private String name;
    private int requiredIngredients;

    public CompletableFuture<Integer> gatherIngredients(Potion potion) {
        return CompletableFuture.supplyAsync(() -> {
            long gatheringTimeoutByAmountIngredients = new Random().nextLong(potion.getRequiredIngredients());
            try {
                Thread.sleep(gatheringTimeoutByAmountIngredients);
            } catch (InterruptedException e) {
                log.error("\nThread was interrupted while he was sleeping");
                throw new IllegalStateException(e);
            }
            System.out.printf("\nIngredients for %s was gather", potion.getName());
            return potion.getRequiredIngredients();
        });
    }

}
