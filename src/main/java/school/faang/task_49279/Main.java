package school.faang.task_49279;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.Random;

@Slf4j
public class Main {
    private static final Random RANDOM = new Random();
    private static final int TWO_SECONDS = 2000;

    @SneakyThrows
    public static void main(String[] args) {
        Game game = new Game();

        for (int i = 0; i < 50; i++) {
            boolean increasePoints = RANDOM.nextBoolean();
            boolean lostLives = RANDOM.nextBoolean();
            try {
                game.update(increasePoints, lostLives);
                Thread.sleep(TWO_SECONDS);
            } catch (GameOverException e) {
                log.info("Game over");
                break;
            }
        }
    }
}
