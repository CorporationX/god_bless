package school.faang.forcebro;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Game {
    @Getter
    private boolean isGameOver = false;
    private final Object scoreSynchronized = new Object();
    private final Object livesSynchronized = new Object();
    private int score = 0;
    private int lives = 10;

    public void update(boolean isAddScore, boolean isHealthLost) {
        synchronized (livesSynchronized) {
            if (isHealthLost) {
                try {
                    if (lives <= 1) {
                        gameOver();
                        return;
                    }
                    lives--;
                    log.info("Жизни уменьшены, оставшиеся жизни: {}", lives);
                } finally {
                    livesSynchronized.notifyAll();
                }
            }
        }

        synchronized (scoreSynchronized) {
            if (isAddScore) {
                try {
                    score++;
                    log.info("Очки увеличены, текущий счёт: {}", score);
                } finally {
                    scoreSynchronized.notifyAll();
                }
            }
        }
    }

    private void gameOver() {
        this.isGameOver = true;
        log.info("Игра окончена");
    }
}
