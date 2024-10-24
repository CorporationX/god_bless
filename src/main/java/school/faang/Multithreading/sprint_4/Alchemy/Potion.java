package school.faang.Multithreading.sprint_4.Alchemy;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;

@Slf4j
@AllArgsConstructor
@Getter
public class Potion {
    public final static long WORK_TIME = 3000;
    private String name;
    private int requiredIngredients;

    public CompletableFuture<Integer> gatherIngredients(Potion potion){
        CompletableFuture<Integer> gatherFuture = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(WORK_TIME);
            } catch (InterruptedException e) {
                log.error("Error", e);
                throw new RuntimeException(e);
            }

            return potion.requiredIngredients;
        });
        return gatherFuture;
    }
}