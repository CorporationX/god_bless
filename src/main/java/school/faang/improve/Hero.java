package school.faang.improve;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.Random;

@Slf4j
@Getter
@Setter
@AllArgsConstructor
public class Hero {
    private static final int MAX_TIME_TO_GATHER = 5_000;
    private final Random random;
    private String name;

    public int gatherIngredients(Potion potion) {
        log.info("{} is gathering ingredients for {}", name, potion.getName());
        try {
            Thread.sleep(random.nextInt(MAX_TIME_TO_GATHER));
        } catch (InterruptedException e) {
            log.warn("Thread {} interrupted while gathering ingredients", Thread.currentThread().getName());
            return 0; // Return 0 if interrupted
        }
        log.info("{} got ingredients for {}", name, potion.getName());
        return potion.getRequiredIngredients();
    }
}