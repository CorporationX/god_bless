package faang.school.godbless.Sprint4Future.Alchemy;

import lombok.AllArgsConstructor;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
@AllArgsConstructor
public class Potion {
    private String name;
    private int requiredIngredients;


    public static CompletableFuture<Integer> gatherIngredients(Potion potion){
        try {
            TimeUnit.MILLISECONDS.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return CompletableFuture.supplyAsync(() -> potion.requiredIngredients);
    }
}
