package school.faang.bjs2_90102;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicInteger;

@Getter
@Slf4j
public class Game {
    private static final int COUNT_AVAILABLE_LIVES = 0;
    private final AtomicInteger lives = new AtomicInteger(10);
    private final AtomicInteger score =  new AtomicInteger(0);

    public int getLivesCount() {
        return lives.get();
    }

    public void update(boolean isPointEarned, boolean isLifeLost) {
        if (isPointEarned) {
            int remainingScore = score.incrementAndGet();
            log.info("Очки увеличены, текущий счёт: {}", remainingScore);
        }

        if (isLifeLost) {
            int remainingLives = lives.decrementAndGet();
            log.info("Жизни уменьшены, оставшиеся жизни: {}", remainingLives);

            if (remainingLives <= COUNT_AVAILABLE_LIVES) {
                gameOver();
            }
        }
    }

    private void gameOver() {
        log.info("Игра окончена! Все жизни потеряны.");
    }
}
