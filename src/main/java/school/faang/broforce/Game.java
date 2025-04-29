package school.faang.broforce;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
public class Game {
    private int score = 0;
    private int lives;
    private final Object lockScore = new Object();
    private final Object lockLives = new Object();

    public Game(int lives) {
        this.lives = lives;
    }

    public void update(boolean scored) {
        if (scored) {
            synchronized (lockScore) {
                if (isOver()) {
                    throw new IllegalStateException("Game is Over!");
                }
                score++;
                log.info("Score incremented: {}", score);
            }
        } else {
            synchronized (lockLives) {
                if (isOver()) {
                    throw new IllegalStateException("Game is Over!");
                }
                lives--;
                log.info("Life lost, remaining lives: {}", lives);
                if (lives <= 0) {
                    gameOver();
                    lives = 0;
                }
            }
        }
    }

    private void gameOver() {
        log.info("Game Over! Final Score: {}", score);
    }

    private boolean isOver() {
        if (this.getLives() <= 0) {
            log.error("Trying to play after Game Over!");
            return true;
        }
        return false;
    }
}
