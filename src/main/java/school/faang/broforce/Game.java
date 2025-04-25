package school.faang.broforce;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
public class Game {
    private int score = 0;
    private int lives;
    private final Object lock = new Object();

    public Game(int lives) {
        this.lives = lives;
    }

    public void update(boolean scored) {
        synchronized (lock) {
            if (this.getLives() <= 0) {
                log.error("Trying to play after Game Over!");
                throw new IllegalArgumentException("You are trying to play after Game Over!");
            }
            if (scored) {
                score++;
                log.info("Score incremented: {}", score);
            } else {
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
}
