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

    private final Random random = new Random();
    private String name;

    public void gatherIngredients(Potion potion) {
        log.info("{} is gathering ingredients for {}", name, potion.getName());
        try {
            Thread.sleep(random.nextInt(5_000));
        } catch (InterruptedException e) {
            log.error("Caught exception", e);
            throw new IllegalStateException(
                    String.format("Thread %s interrupted", Thread.currentThread().getName()), e
            );
        }
        log.info("{} got ingredients for {}", name, potion.getName());
    }
}
