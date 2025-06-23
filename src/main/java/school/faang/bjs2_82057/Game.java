package school.faang.bjs2_82057;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Game {
    private final Object scoreLock = new Object();
    private final Object livesLock = new Object();

    private int score = 0;
    private int lives = 5;

    private boolean isGameOver = false;

    public void update(boolean isScored, boolean isLiveLost) {
        if (isScored) {
            synchronized (scoreLock) {
                score++;
                log.info("урааа 0чк0, счет: {}", score);
            }
        }
        if (isLiveLost) {
            synchronized (livesLock) {
                if (lives <= 0) {
                    gameOver();
                }
                lives--;
                log.info("zдоровье уменьшено, текущее zдоровье: {}", lives);
            }
        }
    }

    private void gameOver() {
        isGameOver = true;
        log.info("игра окончена");
    }

    public boolean isOver() {
        return isGameOver;
    }
}
