package school.faang.sprint_3.task_bjs249291;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.Random;

@Slf4j
public class Game {
    private static final Random RANDOM = new Random();

    private final Object scoreLock = new Object();
    private final Object livesLock = new Object();

    @Getter
    private boolean gameOver = false;
    private int lives;
    private int score;

    public Game(int lives) {
        this.lives = lives;
        score = 0;
    }

    public void update() {
        boolean earnedPoints = RANDOM.nextBoolean();
        boolean lostLife = RANDOM.nextBoolean();

        synchronized (scoreLock) {
            if (earnedPoints) {
                score++;
                log.info("Current score: {}", score);
            }
        }
        synchronized (livesLock) {
            if (lostLife) {
                lives--;
                log.info("Current lives: {}", lives);
                if (lives <= 0) {
                    gameOver();
                }
            }
        }
    }

    private void gameOver() {
        log.info("Game is over. Current lives: {} Current score: {}", lives, score);
        gameOver = true;
    }
}
