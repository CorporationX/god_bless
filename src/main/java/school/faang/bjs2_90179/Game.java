package school.faang.bjs2_90179;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Game {

    private int score = 0;
    private int lives = 100;
    private final Object livesLock = new Object();
    private final Object scoreLock = new Object();

    public  void update(boolean isLifeLost, boolean isScoreUp) {
        synchronized (livesLock) {
            if (isLifeLost) {
                lives--;
                if (lives <= 0) {
                    gameOver();
                }
                log.info("Live was lost, current lives: {}", lives);
            }
        }
        synchronized (scoreLock) {
            if (isScoreUp) {
                score++;
                log.info("Point scored, current score: {}", score);
            }
        }
    }

    private void gameOver() {
        throw new RuntimeException("Game is over!");
    }
}
