package bjs2_73722;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Getter
@Slf4j
public class Game {
    private int score = 0;
    private int lives = 10;
    private static Object lockForScore = new Object();
    private static Object lockForLives = new Object();
    boolean isGameOver = false;

    public void update(boolean changingScore, boolean changingLives) {
        if (isGameOver) {
            return;
        }
        if (changingScore) {
            synchronized (lockForScore) {
                score++;
                log.info("The total score for the game increased by 1!");
            }
        }
        if (changingLives) {
            synchronized (lockForLives) {
                if (lives < 1) {
                    gameOver();
                    return;
                }
                lives--;
                log.info("The total number of lives per game has decreased by 1!");
            }
        }

    }

    private void gameOver() {
        isGameOver = true;
        log.info("The game is over! Final score: {}", score);
    }
}
