package school.faang.broforce;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.Random;

@Slf4j
@Getter
public class Game {
    Random random = new Random();

    private int score = 0;
    private int lives = 5;
    private boolean isTheEnd = false;
    private final Object scoreLock = new Object();
    private final Object livesLock = new Object();

    public void update(boolean earnedScore, boolean lostLive) {
        synchronized (scoreLock) {
            if (earnedScore) {
                score++;
                log.info("Счёт увеличен, текущий счёт - {}", score);
            }
            synchronized (livesLock) {
                if (lostLive) {
                    lives--;
                    log.info("Количество жизней уменьшено, текущее количество - {}", lives);
                    if (lives <= 0) {
                        isTheEnd = true;
                        gameOver();
                    }
                }
            }
        }
    }

    private void gameOver() {
        log.info("The end");
    }
}
