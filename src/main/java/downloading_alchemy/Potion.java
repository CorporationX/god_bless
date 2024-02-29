package downloading_alchemy;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.concurrent.CompletableFuture;

@AllArgsConstructor
@Data
public class Potion {
    private String name;
    private int requiredIngredients;

    public int gatherIngredients() {
        try {
            Thread.sleep(1000 * requiredIngredients);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return requiredIngredients;
    }
}