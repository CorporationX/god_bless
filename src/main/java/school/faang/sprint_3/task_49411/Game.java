package school.faang.sprint_3.task_49411;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
public class Game {
    private static final double CHANCE_TO_EARN_POINTS = 0.7;
    private static final double CHANCE_TO_LOSE_LIFE = 0.5;
    private int score;
    private int lives;
    private boolean lostLife;
    private boolean earnedPoints;
    private final Object scoreLock;
    private final Object liveLock;


    public Game() {
        scoreLock = new Object();
        liveLock = new Object();
        score = 0;
        lives = 10;
        lostLife = false;
        earnedPoints = false;
    }

    public void update(boolean earnedPoints, boolean lostLife) {
        synchronized (scoreLock) {
            if (earnedPoints && lives > 0) {
                score++;
                log.info("{} - earned scores", score);
            }
        }
        synchronized (liveLock) {
            if (lostLife && lives > 0) {
                lives--;
                log.info("{} - remaining lives", lives);
            }
            if (lives == 0) {
                gameOver();
            }
        }
    }

    private void gameOver() {
        log.info("Game over! You have run out of lives! Your earned points: {}", score);
        Thread.currentThread().interrupt();
    }

    public boolean isEarnedPoints() {
        return earnedPoints = Math.random() > CHANCE_TO_EARN_POINTS;
    }

    public boolean isLostLife() {
        return lostLife = Math.random() > CHANCE_TO_LOSE_LIFE;
    }
}
