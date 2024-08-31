package faang.school.godbless.gain_alch;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;

@Getter
@AllArgsConstructor
@Slf4j
public class Potion {
    private String name;
    private int requiredIngredients;

    public static CompletableFuture<Integer> gatherIngredients(Potion potion) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
            log.info("Gathered %d ingredients for %s"
                    .formatted(potion.getRequiredIngredients(), potion.getName()));
            return potion.getRequiredIngredients();
        });
    }
}
