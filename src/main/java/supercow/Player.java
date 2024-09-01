package supercow;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

@RequiredArgsConstructor
@Getter
public class Player {
    private final String name;
    private static final Random random = ThreadLocalRandom.current();

    public void battle() {
        try {
            System.out.printf("Игрок %s начал битву%n", this.name);
            long battleTime = random.nextLong(1, 10) * 1000;
            Thread.sleep(battleTime);
            System.out.printf("Игрок %s закончил битву за %d секунд%n", this.name, battleTime / 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
