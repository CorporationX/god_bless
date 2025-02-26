package school.faang.task61852;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
public class Game {
    private static final int DEFAULT_SCORE = 0;
    private static final int DEFAULT_LIVES = 3;
    private int score = DEFAULT_SCORE;
    private int lives = DEFAULT_LIVES;
    private final Object scoreLock = new Object();
    private final Object livesLock = new Object();

    public void update(boolean isScoreUpdated, boolean isLivesLost) {
        synchronized (scoreLock) {
            score++;
        }

        synchronized (livesLock) {
            lives--;
            if (lives <= 0) {
                gameOver();
            }
        }
    }

    private void gameOver() {
        log.info("Игра окончена, всего очков: {}", score);
        score = DEFAULT_SCORE;
        lives = DEFAULT_LIVES;
    }
}
