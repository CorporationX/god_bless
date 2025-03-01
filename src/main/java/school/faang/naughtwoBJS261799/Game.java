package school.faang.naughtwoBJS261799;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Scanner;

@Slf4j
public class Game {
    private static final int AVAILABLE_LIVES = 3;
    private static final int START_SCORE = 0;

    private int score = START_SCORE;
    private int lives = AVAILABLE_LIVES;

    private boolean isGameOver = false;

    private final Object lockScore = new Object();
    private final Object lockLives = new Object();

    public void update(boolean isPointsEarned, boolean isLifeLost) {
        if (!isGameOver) {
            if (isPointsEarned) {
                updateScore();
            }
            if (isLifeLost) {
                updateLives();
            }
        } else {
            log.info("Game over, restart?");
            restartGame();
        }
    }

    private void updateScore() {
        synchronized (lockScore) {
            score++;
            log.info("Points increased, current score: {}", score);
        }
    }

    private void updateLives() {
        synchronized (lockLives) {
            lives--;
            log.info("Lives reduced, remaining lives: {}", lives);
            if (lives == 0) {
                gameOver();
            }
        }
    }

    private void gameOver() {
        isGameOver = true;
        log.info("Game over");
    }

    private synchronized void restartGame() {
        log.info("Enter any character to restart");
        Scanner scan = new Scanner(System.in);
        if (!scan.nextLine().isBlank()) {
            score = START_SCORE;
            lives = AVAILABLE_LIVES;
            isGameOver = false;
            log.info("Game restart");
        } else {
            gameOver();
            System.exit(0);
        }
    }
}
