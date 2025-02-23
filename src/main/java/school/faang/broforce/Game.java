package school.faang.broforce;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;

@Slf4j
@Getter
public class Game {
    private int score = 0;
    private int lives = 10;

    private final Object lockScore = new Object();
    private final Object lockLives = new Object();

    public void update(boolean isEarnedPoints, boolean isLostLife) {
        validateArguments(isEarnedPoints, isLostLife);
        synchronized (lockScore) {
            if (isEarnedPoints) {
                score++;
                log.info("Счётчик обновлён потоком {} сейчас значение: {}", Thread.currentThread().getName(), score);
            }
        }
        synchronized (lockLives) {
            if (isLostLife) {
                if (lives - 1 == 0) {
                    gameOver();
                } else {
                    lives--;
                    log.info("Количество жизней обновлено потоком {} сейчас значение: {}",
                            Thread.currentThread().getName(), lives);
                }
            }
        }

    }

    private void gameOver() {
        log.info("Игра завершена потоком {}", Thread.currentThread().getName());
    }

    private <T, U> void validateArguments(T argumentFirst, U argumentSecond) {
        Objects.requireNonNull(argumentFirst, "Переданный аргумент не может быть null");
        Objects.requireNonNull(argumentSecond, "Переданный аргумент не может быть null");
    }
}