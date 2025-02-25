package school.faang.broforce;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@AllArgsConstructor
public class Game {
    private final Object scoreLock = new Object();
    private final Object livesLock = new Object();
    private int score;
    private int lives;

    public void update(boolean isSettingPoints, boolean isLosingLife) {
        if (isSettingPoints) {
            synchronized (scoreLock) {
                score++;
                log.info("Увеличивается счетчик очков == {}", score);
            }
        }
        if (isLosingLife) {
            synchronized (livesLock) {
                synchronized (livesLock) {
                    lives--;
                    log.info("Уменьшается количество жизней == {}", lives);
                    if (lives <= 0) {
                        gameOver();
                    }
                }
            }
        }
    }

    private void gameOver() {
        log.info("Игра окончена!");
    }
}
