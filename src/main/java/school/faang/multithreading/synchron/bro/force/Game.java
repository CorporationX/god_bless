package school.faang.multithreading.synchron.bro.force;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Game {
    private int score;
    private int lives;
    private final Object scoreLock = new Object();
    private final Object livesLock = new Object();

    public Game(int lives) {
        this.lives = lives;
    }

    @SneakyThrows
    public void update(boolean isIncreaseScore, boolean isReduceLife) {
        if (isIncreaseScore) {
            synchronized (scoreLock) {
                if (lives == 0) {
                    return;
                }
                score++;
                log.info("Победа! Ваш счет: {}", score);
            }
        }

        if (isReduceLife) {
            synchronized (livesLock) {
                if (lives > 0) {
                    lives--;
                    System.out.println();
                    log.info("Потеряна жизнь. Осталось жизней: {}", lives);
                    if (lives == 0) {
                        gameOver();
                    }
                }
            }
        }
    }

    private void gameOver() {
        log.info("Игра окончена. Ваш финальный счет: {}", score);
    }
}
