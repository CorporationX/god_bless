package school.faang.broforce;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Game {
    private int score;
    private int lives;

    public Game() {
        score = 0;
        lives = 5;
    }

    private final Object scoreLock = new Object();
    private final Object livesLock = new Object();

    public void update(boolean point, boolean life) {
        if (point) {
            synchronized (scoreLock) {
                score++;
                log.info("{}: добавил 1 очко. Общий счет: {}", Thread.currentThread().getName(), score);
            }
        }
        if (life) {
            synchronized (livesLock) {
                lives--;
                log.info("{}: потерял 1 жизнь. Количество жизней: {}", Thread.currentThread().getName(), lives);
                if (lives <= 0) {
                    gameOver();
                }

            }
        }

    }

    private void gameOver() {
        log.info("Игра окончена! Все жизни потеряны.");
        System.exit(0);
    }

}
