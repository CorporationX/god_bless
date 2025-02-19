package school.faang;

import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Getter
public class Game {
    private static final Logger logger = LoggerFactory.getLogger(Game.class);
    private int score = 0;
    private int lives;
    private final Object scoreLocker = new Object();
    private final Object livesLocker = new Object();

    public Game(int lives) {
        this.lives = lives;
    }

    public void update(boolean isPointEarned, boolean isLifeLost) {
        synchronized (scoreLocker) {
            if (isPointEarned) {
                logger.info("The player got a point.");
                score++;
            }
        }

        synchronized (livesLocker) {
            if (isLifeLost) {
                if (lives == 0) {
                    gameOver();
                } else if (lives < 0) {
                    logger.error("Game is already over.");
                }
                lives--;
            }
        }
    }

    private void gameOver() {
        logger.info("Game is over.");
    }
}
