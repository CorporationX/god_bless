package school.faang.task_49301;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class Game {
    private final AtomicInteger score = new AtomicInteger(0);
    private final AtomicInteger lives = new AtomicInteger(10);

    @SneakyThrows
    public void update(boolean earnedPoints, boolean lostLife) {
        if (earnedPoints) {
            int updatedScore = score.incrementAndGet();
            log.info("Очки увеличены, текущий счёт: {}", updatedScore);
        }

        if (lostLife) {
            int remainingLives = lives.decrementAndGet();
            log.info("Жизни уменьшены, оставшиеся жизни: {}", remainingLives);

            if (remainingLives <= 0) {
                gameOver();
            }
        }
    }

    private void gameOver() {
        log.info("Игра окончена! Итоговый счёт: {}", score);
    }
}
