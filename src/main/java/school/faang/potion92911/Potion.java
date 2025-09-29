package school.faang.potion92911;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.concurrent.CompletableFuture;

@AllArgsConstructor
@Getter
public class Potion {
    private String name;
    private int requiredIngredients;

    public static int gatherIngredients(Potion potion) {
        try {
            Thread.sleep(potion.getRequiredIngredients() * 300L);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
        return potion.getRequiredIngredients();
    }
}
