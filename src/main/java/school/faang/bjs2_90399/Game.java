package school.faang.bjs2_90399;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Slf4j
@Getter
public class Game {
    private static final int LIVES_SQUAD = 10;
    private static final int DEFAULT_SCORE = 0;
    private final Lock scoreLock = new ReentrantLock();
    private final Lock livesLock = new ReentrantLock();
    private int lives = LIVES_SQUAD;
    private int score = DEFAULT_SCORE;

    public void update(boolean isPointEarned, boolean isLifeLost) {
        if (isPointEarned) {
            scoreLock.lock();
            try {
                score++;
                log.info("Очки увеличены, текущий счет: {}", score);
            } finally {
                scoreLock.unlock();
            }
        }
        if (isLifeLost) {
            livesLock.lock();
            try {
                lives--;
                if (lives <= 0) {
                    gameOver();
                    return;
                }
                log.info("Жизни уменьшены, оставшиеся жизни : {}", lives);
            } finally {
                livesLock.unlock();
            }
        }
    }

    private void gameOver() {
        log.info("Ваша игра закончилась с общим счетом счетом {}", score);
    }
}
