package school.faang.bjs2_82098;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicBoolean;

@NoArgsConstructor
@Getter
@Slf4j
public class Game {
    private int score = 0;
    private int lives = 10;

    private final Object scoreLock = new Object();
    private final Object livesLock = new Object();

    private final AtomicBoolean gaming = new AtomicBoolean(false);

    private void gameOver() {
        gaming.set(false);
        log.info("GAME OVER!");
    }

    public void start() {
        gaming.set(true);
        log.info("Game started");
    }

    public void update(boolean isPointsEarned, boolean isLifeLost) {
        if (!gaming.get()) {
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
