package school.faang.bjs2_73761;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
public class Game {
    private int score;
    private int lives;
    private boolean isGameOver;
    private final Object scoreMonitor = new Object();
    private final Object livesMonitor = new Object();

    public Game(int lives) {
        this.lives = lives;
    }

    public void update(boolean isPointsEarned, boolean isLiveLost) {
        if (isLiveLost) {
            synchronized (livesMonitor) {
                if (lives-- <= 0) {
                    gameOver();
                } else {
                    log.info("You lost one live.. Now you have {} lives", lives);
                }
            }
        }
        if (isPointsEarned) {
            synchronized (scoreMonitor) {
                score++;
                log.info("You got points... Current score is {}", score);
            }
        }
    }

    private void gameOver() {
        log.info("The game is over because you lost all your lives. Good luck next time!");
        isGameOver = true;
    }
}