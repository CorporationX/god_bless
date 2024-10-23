package school.faang.m1s4.bjs_38657_alchemy;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
public class Potion {
    private final String name;
    private final int requiredIngredients;

    public int gatherIngredients() {
        try {
            Thread.sleep(requiredIngredients * 1000L);
        } catch (InterruptedException e) {
            log.error("Thread has been terminated ", e);
        }
        System.out.printf("%d %d ingredients for %s are gathered%n",
                Thread.currentThread().getId(), requiredIngredients, name);
        return requiredIngredients;
    }
}
