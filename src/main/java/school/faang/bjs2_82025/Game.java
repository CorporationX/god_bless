package school.faang.bjs2_82025;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Game {
    @Getter
    private boolean isGameOver = false;
    private int score;
    private int lives = 10;
    private final Object scoreLock = new Object();
    private final Object livesLock = new Object();
    private final Object gameOverLock = new Object();

    public void update(boolean isScored) {
        if (isScored) {
            synchronized (scoreLock) {
                synchronized (gameOverLock) {
                    if (!isGameOver) {
                        score++;
                        log.info("Общее кол-во очков увеличено - {}", score);
                    }
                }
            }
        } else {
            synchronized (livesLock) {
                if (!isGameOver) {
                    lives--;
                    log.info("Общее кол-во жизней уменьшено - {}", lives);
                    if (lives <= 0) {
                        gameOver();
                    }
                }
            }
        }
    }

    private void gameOver() {
        this.isGameOver = true;
        log.info("Игра окончена");
    }
}
