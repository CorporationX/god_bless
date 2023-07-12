package faang.school.godbless.leveling_up_alchemy;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.concurrent.CompletableFuture;

@AllArgsConstructor
@Getter
public class Potion {
    private String name;
    private int requiredIngredients;

    public static CompletableFuture<Integer> gatherIngredients(Potion potion) {
        CompletableFuture<Integer> result = CompletableFuture.supplyAsync(() -> {
            for(int i = 0; i < potion.getRequiredIngredients(); i++) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            return potion.getRequiredIngredients();
        });
        return result;
    }
}
