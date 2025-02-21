package BJS2_62020;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
public class Game {
    private int score = 0;
    private int lives = 25;

    private final Object scoreLock = new Object();
    private final Object livesLock = new Object();

    public void update(boolean isScore, boolean isLives) {
        if (isScore) {
            synchronized (scoreLock) {
                score++;
                log.info("Score earned: {}", score);
            }
        }

        if (isLives) {
            synchronized (livesLock) {
                lives--;
                log.info("Lives left: {}", lives);

                if (lives <= 0) {
                    gameOver();
                }
            }
        }



    }

    private void gameOver() {
        log.info("Game Over");

        synchronized (scoreLock) {
            log.info("Final score: {}", score);
        }
    }
}
