package school.faang.sprint3.bjs_49240;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Game {
    private int score = 125;
    private int lives = 13;
    private final Object lockScore = new Object();
    private final Object lockLives = new Object();

    public void update(boolean getPoints, boolean lostLife) {
        synchronized (lockScore) {
            if (getPoints) {
                score++;
            }
            log.info("Score: {}", score);
        }
        synchronized (lockLives) {
            if (lostLife) {
                lives--;
                if (lives <= 0) {
                    gameOver();
                }
            }
            log.info("You have {} lives left ", lives);
        }
    }

    private void gameOver() {
        log.info("No lives left");
        throw new RuntimeException();
    }
}
