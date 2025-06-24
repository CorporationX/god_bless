package school.faang.bjs2_82098;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@NoArgsConstructor
@Getter
@Slf4j
public class Game {
    private int score = 0;
    private int lives = 10;

    private final Object scoreLock = new Object();
    private final Object livesLock = new Object();

    private volatile boolean gaming = false;

    private void gameOver() {
        gaming = false;
        log.info("GAME OVER!");
    }

    public void start() {
        gaming = true;
        log.info("Game started");
    }

    public void update(boolean isPointsEarned, boolean isLifeLost) {
        if (!gaming) {
            return;
        }

        if (isPointsEarned) {
            synchronized (scoreLock) {
                score++;
                log.info("Points increased, the number of points: {}", score);
            }
        }

        if (isLifeLost) {
            synchronized (livesLock) {
                if (lives > 0) {
                    lives--;
                    log.info("Life lost. Remaining lives: {}", lives);

                    if (lives == 0) {
                        gameOver();
                    }
                }
            }
        }
    }
}
