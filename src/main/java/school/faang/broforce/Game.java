package school.faang.broforce;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Game {
    private int score = 0;
    private int lives = 10;
    private final Object lockScore = new Object();
    private final Object lockLives = new Object();
    private boolean isGameOver = false;

    public void update(boolean isScored, boolean isLostLive) {
        synchronized (lockScore) {
            if (isScored && !isGameOver) {
                score++;
                log.info("Число очков увеличено на 1");
            }
        }
        synchronized (lockLives) {
            if (isLostLive && !isGameOver) {
                lives--;
                log.info("Количество жизней -1");
                if (lives == 0) {
                    gameOver();
                }
            }
        }
    }

    private void gameOver() {
        isGameOver = true;
        log.info("Game over");
    }
}
