package school.faang.task_61841;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
public class Game {
    private int score = 0;
    private int lives = 5;
    private final Object scoreLock = new Object();
    private final Object livesLock = new Object();
    private boolean gameOver = false;

    public void update() {
        synchronized (scoreLock) {
            if (!gameOver) {
                score++;
                log.info("Сумма надранных очков равна {} ", score);
            }
        }
        synchronized (livesLock) {
            if (getLives() < 1) {
                if (!gameOver) {
                    gameOver = true;
                    gameOver();
                }
            } else {
                log.info("Игрок потратил жизнь");
                lives--;
            }
        }
    }

    private void gameOver() {
        log.info("YOU DIED!");
    }
}
