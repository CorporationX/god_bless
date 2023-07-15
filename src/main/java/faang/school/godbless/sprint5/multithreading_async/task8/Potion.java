package faang.school.godbless.sprint5.multithreading_async.task8;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

@Getter
@Setter
@AllArgsConstructor
public class Potion {

    private String name;

    private int requiredIngredients;

    public static CompletableFuture<Integer> gatherIngredients(Potion potion) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return potion.getRequiredIngredients();
        });
    }
}
