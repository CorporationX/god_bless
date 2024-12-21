package school.faang.task_49260;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Game {
    private static final int DEFAULT_LIVES = 10;

    private int score;
    private int lives;
    private volatile boolean isGameOver;

    private final Object scoreLock;
    private final Object livesLock;

    public Game() {
        this.score = 0;
        this.lives = DEFAULT_LIVES;
        this.isGameOver = false;

        this.scoreLock = new Object();
        this.livesLock = new Object();
    }

    public void update(boolean earnedPoints, boolean lostLife) {
        if (earnedPoints) {
            synchronized (scoreLock) {
                score++;
                log.info("Очки увеличены, текущий счёт: {}", score);
            }
        }

        if (lostLife) {
            synchronized (livesLock) {
                lives--;
                log.warn("Жизни уменьшены, оставшиеся жизни: {}", lives);
                if (lives <= 0) {
                    gameOver();
                }
            }
        }
    }

    private void gameOver() {
        isGameOver = true;
        log.info("Игра окончена! Все жизни потеряны.\nТекущий счёт: {}", score);
    }

    public boolean isGameOver() {
        return isGameOver;
    }

}
