package school.faang.bjs2_82667;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;

@Slf4j
@RequiredArgsConstructor
public class PotionService {

    private static final int MS_IN_SECOND = 1000;
    private final ExecutorService executor;

    public CompletableFuture<Integer> collectIngridients(Potion potion) {
        return  CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(potion.getNumberOfIngredients() * MS_IN_SECOND);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                log.error("Interrupted");
            }
            return potion.getNumberOfIngredients();
        }, executor);
    }
}
