package school.faang.broforce;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Game {

    private static final Logger LOGGER = LoggerFactory.getLogger(Game.class);
    private boolean isGameOver = false;

    private int score = 0;
    private int lives = 100;

    private final Object scoreLock = new Object();
    private final Object livesLock = new Object();

    public void update(boolean isScoreGot, boolean isLifeLost) {
        if (isGameOver) {
            return;
        }
        if (isScoreGot) {
            synchronized (scoreLock) {
                if (isGameOver) {
                    return;
                }
                score++;
                LOGGER.info("Успешный удар! Текущий счет: {}", score);
            }
        }
        if (isLifeLost) {
            synchronized (livesLock) {
                if (isGameOver) {
                    return;
                }
                lives--;
                LOGGER.info("Удар пропущен! Количество здоровья уменьшено! Текущий уровень: {}", lives);
                if (lives == 0) {
                    gameOver();
                }
            }
        }
    }

    private void gameOver() {
        synchronized (this) {
            LOGGER.info("Здоровья не осталось! Игра закончена. Финальный счет: {}", score);
            isGameOver = true;
        }
    }
}
