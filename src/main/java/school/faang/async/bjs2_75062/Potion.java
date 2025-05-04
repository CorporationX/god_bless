package school.faang.async.bjs2_75062;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;

import static school.faang.Utils.handleInterruptedException;

@Slf4j
@AllArgsConstructor
public class Potion {
    private String name;
    private Integer requiredIngredients;

    public CompletableFuture<Integer> gatherIngredients() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            handleInterruptedException(e);
        }
        return CompletableFuture.completedFuture(this.requiredIngredients);
    }

}
