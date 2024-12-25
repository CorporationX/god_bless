package school.faang.task_49311;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Game {
    private static final int MAX_LIVES = 5;
    private int score;
    private int lives;
    private final Object scoreLock;
    private final Object livesLock;

    public Game() {
        this.score = 0;
        this.lives = MAX_LIVES;
        this.scoreLock = new Object();
        this.livesLock = new Object();
    }

    public void update(boolean isPointsEarned, boolean isLifeLost) {
        synchronized (scoreLock) {
            if (isPointsEarned) {
                score++;
                log.info("Добавили 1 очко в счет...");
            }
        }

        synchronized (livesLock) {
            if (isLifeLost) {
                if (lives > 0) {
                    lives--;
                    log.info("Потеряли 1 очко жизни...");
                } else {
                    log.info("Все жизни истрачены...");
                    gameOver();
                }
            }
        }
    }

    private void gameOver() {
        log.info("Игра окончена!");
    }
}
