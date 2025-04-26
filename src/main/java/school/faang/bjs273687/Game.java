package school.faang.bjs273687;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@Setter
public class Game {
    private static final int DEFAULT_LIVES_COUNT = 10;

    private int totalScore = 0;
    private int totalLives = DEFAULT_LIVES_COUNT;
    private boolean isFinished = false;

    private final Object scoreLock = new Object();
    private final Object livesLock = new Object();

    public Game() {
    }

    public Game(int lives) {
        totalLives = lives;
    }

    public void update(boolean isLiveLost, boolean isPointsGained) {
        if (isPointsGained) {
            increaseScores();
        }
        if (isLiveLost) {
            decreaseLive();
        }
    }

    private void decreaseLive() {
        synchronized (livesLock) {
            if (isFinished) {
                return;
            }
            totalLives--;
            log.info("Live  lost. Remained lives: {}", totalLives);
            if (totalLives <= 0) {
                finishGame();
            }
        }
    }

    public void increaseScores() {
        synchronized (scoreLock) {
            if (isFinished) {
                return;
            }
            totalScore++;
            log.info("Score gained. Total score: {}", totalScore);
        }
    }

    private void finishGame() {
        isFinished = true;
        log.info("Game is over. Total score: {}. ", totalScore);
    }
}
