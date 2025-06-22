package school.faang.module1.bjs2_82060;

import lombok.extern.slf4j.Slf4j;

import static school.faang.module1.bjs2_82060.UpdaterType.LIVES;
import static school.faang.module1.bjs2_82060.UpdaterType.SCORE;

@Slf4j
public class Game {

    private int score = 0;
    private int lives = 10;
    private volatile boolean isGameOver = false;

    private final Object scoreLock = new Object();
    private final Object livesLock = new Object();

    public void update(UpdaterType updaterType) {
        if (updaterType == SCORE) {
            synchronized (scoreLock) {
                if (isGameOver) {
                    log.warn("Попытка добавить очки после завершения игры");
                    return;
                }
                score++;
                log.info("Очки увеличены, всего очков: {}", score);
            }
        }
        if (updaterType == LIVES) {
            synchronized (livesLock) {
                if (isGameOver) {
                    return;
                }
                if (lives > 0) {
                    lives--;
                    log.info("Жизни уменьшены, осталось жизней: {}", lives);
                    if (lives == 0) {
                        gameOver();
                    }
                }
            }
        }
    }

    private void gameOver() {
        isGameOver = true;
        int finalScore;
        int finalLives;
        synchronized (scoreLock) {
            finalScore = score;
        }
        synchronized (livesLock) {
            finalLives = lives;
        }
        log.info("Все жизни потеряны! игра окончена");
        log.info("Финальный счёт: {}, оставшиеся жизни: {}", finalScore, finalLives);
    }
}