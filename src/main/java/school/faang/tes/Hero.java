package school.faang.tes;

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

    private final Random random = new Random();
    private String name;

    public int gatherIngredients(Potion potion) {
        log.info("{} is gathering ingredients for {}", name, potion.getName());
        try {
            Thread.sleep(random.nextInt(MAX_TIME_TO_GATHER));
        } catch (InterruptedException e) {
            log.error("Caught exception", e);
            throw new IllegalStateException(
                    String.format("Thread %s interrupted", Thread.currentThread().getName()), e
            );
        }
        log.info("{} got ingredients for {}", name, potion.getName());

        return potion.getRequiredIngredients();
    }
}
