package school.faang.bro_force;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Game {
    private int score = 0;
    private int lives = 100;

    private final Object scoreLock = new Object();
    private final Object livesLock = new Object();

    public void update(boolean addPoint, boolean lostLife) {
        synchronized (scoreLock) {
            if (addPoint) {
                score++;
                log.info("+1 очко");
            }
        }
        synchronized (livesLock) {
            if (lostLife) {
                lives--;
                log.info("-1 life!");
                if (lives <= 0) {
                    gameOver();
                }
            }
        }
    }

    private void gameOver() {
        log.info("GAME OVER! Финальный счет: {}", score);
        System.exit(0);
    }
}
