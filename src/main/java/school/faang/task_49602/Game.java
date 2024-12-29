package school.faang.task_49602;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Game {
    private int score = 0;
    private int lives = 10;
    private final Object scoreLock = new Object();
    private final Object lovesLock = new Object();

    public void update(boolean scored, boolean lostLife) {
        synchronized (scoreLock) {
            if (scored) {
                score++;
                log.info("Score increased. Current score: {}", score);
            }
        }

        synchronized (lovesLock) {
            if (lostLife) {
                lives--;
                log.info("Lives is lost, Left lives: {}", lives);
                if (lives <= 0) {
                    gameOver();
                }
            }
        }
    }

    private void gameOver() {
        log.info("Game over.");
    }
}
