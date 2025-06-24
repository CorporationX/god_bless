package school.faang.bjs2_82041;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
public class Game {
    private final Object lockScore = new Object();
    private final Object lockLives = new Object();

    private int score = 0;
    private int lives;

    public Game(int lives) {
        this.lives = lives;
    }

    private void gameOver() {
        log.info("Game over");
    }

    public void update() {
        synchronized (lockScore) {
            if (Math.random() < 0.5) {
                score++;
                log.info("Score upgraded to {}", score);
            }
        }

        synchronized (lockLives) {
            if (Math.random() < 0.3) {
                lives--;
                log.info("Lives downgraded to {}", lives);
            }

            if (lives == 0) {
                gameOver();
            }
        }
    }
}
